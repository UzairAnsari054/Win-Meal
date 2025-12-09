package com.example.winmeal.meal.presentation.meal_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.winmeal.core.presentation.theme.DarkBlue
import com.example.winmeal.meal.domain.Meal
import com.example.winmeal.meal.presentation.meal_list.components.MealSearchBar
import org.koin.androidx.compose.koinViewModel

@Composable
fun MealListScreenRoot(
    viewModel: MealListViewModel = koinViewModel(),
    onMealClick: (Meal) -> Unit
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    MealListScreen(
        state = state,
        onAction = { action ->
            when (action) {
                is MealListAction.OnMealClick -> onMealClick(action.meal)
                else -> Unit
            }
            viewModel.onAction(action)
        }
    )
}

@Composable
private fun MealListScreen(
    state: MealListState,
    onAction: (MealListAction) -> Unit
) {
    val keyboardController = LocalSoftwareKeyboardController.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkBlue)
            .statusBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MealSearchBar(
            searchQuery = state.searchQuery,
            onSearchQueryChange = {
                onAction(MealListAction.OnSearchQueryChanged(it))
            },
            onImeSearch = {
                keyboardController?.hide()
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun MealListScreenPreview() {
    val state = MealListState()
    MealListScreen(
        state = state,
        onAction = {})
}