package com.example.winmeal.meal.presentation.meal_list

import com.example.winmeal.core.presentation.UiText
import com.example.winmeal.meal.domain.Meal

data class MealListState(
    val isLoading: Boolean = true,
    val errorMessage: UiText? = null,
    val searchQuery: String = "Beef",
    val searchResult: List<Meal> = emptyList(),
    val selectedTabIndex: Int = 0
)
