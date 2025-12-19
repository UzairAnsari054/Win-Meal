package com.example.winmeal.meal.presentation.meal_list

import com.example.winmeal.core.presentation.UiText
import com.example.winmeal.meal.domain.Meal

data class MealListState(
    val isLoading: Boolean = false,
    val errorMessage: UiText? = null,
    val searchQuery: String = "Beef",
    val searchResult: List<Meal>  =meals,
    val favoriteMeals: List<Meal> = emptyList(),
    val selectedTabIndex: Int = 0
)

private val meals = (1..100).map {
    Meal(
        id = it.toString(),
        name = "Beef Stew $it",
        imageUrl = "https://www.test.com",
        category = "Beef",
        origin = "Indian"
    )
}