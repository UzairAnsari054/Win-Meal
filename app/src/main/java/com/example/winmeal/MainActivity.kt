package com.example.winmeal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.winmeal.core.presentation.theme.WinMealTheme
import com.example.winmeal.meal.presentation.meal_list.MealListScreenRoot
import com.example.winmeal.meal.presentation.meal_list.MealListViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WinMealTheme {
                MealListScreenRoot(
                    viewModel = remember { MealListViewModel() },
                    onMealClick = {}
                )
            }
        }
    }
}