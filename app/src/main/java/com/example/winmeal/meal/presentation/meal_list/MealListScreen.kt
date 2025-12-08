package com.example.winmeal.meal.presentation.meal_list

import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.winmeal.meal.domain.Meal
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

}

@Preview(showBackground = true)
@Composable
private fun MealListScreenPreview() {
    val state = MealListState()
    MealListScreen(
        state = state,
        onAction = {})
}