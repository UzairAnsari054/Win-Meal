package com.example.winmeal.meal.presentation.meal_list

import com.example.winmeal.meal.domain.Meal

sealed interface MealListAction {
    class OnSearchQueryChanged(val query: String): MealListAction
    class OnTabChanged(val index: Int): MealListAction
    class OnMealClick(val meal: Meal): MealListAction
}