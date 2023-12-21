package com.example.dailycostaccountingexam

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.dailycostaccountingexam.ui.screens.AddCategoryScreen
import com.example.dailycostaccountingexam.ui.screens.AddExpenseScreen
import com.example.dailycostaccountingexam.ui.screens.ExpenseListScreen
import com.example.dailycostaccountingexam.ui.screens.ExpenseStatisticScreen
import com.example.dailycostaccountingexam.ui.screens.JokeScreen
import com.example.dailycostaccountingexam.ui.theme.DailyCostAccountingExamTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DailyCostAccountingExamTheme {
                val expenseViewModel = viewModel<ExpenseViewModel>()
                val categoryViewModel = viewModel<CategoryViewModel>()
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "/expense-list") {
                    composable("/expense-list") {
                        ExpenseListScreen(expenseViewModel, navController)
                    }
                    composable("/add-expense") {
                        AddExpenseScreen(categoryViewModel, expenseViewModel, navController)
                    }
                    composable("/add-category") {
                        AddCategoryScreen(categoryViewModel, navController)
                    }
                    composable("/expense-statistic") {
                        ExpenseStatisticScreen(categoryViewModel, expenseViewModel ,navController)
                    }
                }
            }
        }
    }
}
