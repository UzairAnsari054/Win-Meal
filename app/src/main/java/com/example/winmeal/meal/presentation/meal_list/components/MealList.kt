package com.example.winmeal.meal.presentation.meal_list.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.winmeal.meal.domain.Meal

@Composable
fun MealList(
    meals: List<Meal>,
    onMealClick: (Meal) -> Unit,
    modifier: Modifier = Modifier,
    scrollState: LazyListState = rememberLazyListState()
) {
    LazyColumn(
        modifier = modifier,
        state = scrollState,
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(
            items = meals,
            key = { it.id }
        ) { meal ->
            MealListItem(
                meal = meal,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                onClick = {
                    onMealClick(meal)
                }
            )
        }
    }
}

private val meals = (1..100).map {
    Meal(
        id = it.toString(),
        name = "Beef Stew $it",
        imageUrl = "https://www.test.com",
        category = "Beef",
        origin = "Indian"
    )
}

@Preview(showBackground = true)
@Composable
private fun MealListPreview() {
    MealList(
        meals = meals,
        onMealClick = {}
    )
}