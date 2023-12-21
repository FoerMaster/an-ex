package com.example.dailycostaccountingexam.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.dailycostaccountingexam.ExpenseViewModel

@Composable
fun ExpenseListScreen(
    expenseViewModel: ExpenseViewModel,
    navController: NavController) {

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White),
        contentAlignment = Alignment.Center
    )
    {
        Column (
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize(0.95f)
                .verticalScroll(rememberScrollState())
        ) {

            JokeScreen()

            Row(verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth().padding(vertical = 14.dp),
            ){
                Text(text="Список расходов", fontSize = 24.sp, fontWeight = FontWeight.Bold)
            }

            if (expenseViewModel.expense.isEmpty())
                Row(verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth().padding(vertical = 14.dp),
                ){
                    Text(text="Пусто...", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.LightGray)
                }
            expenseViewModel.expense.forEach{
                    expense ->
                Card(modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .padding(4.dp)) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp, 0.dp, 15.dp, 0.dp)
                    )
                    {
                        Column(modifier = Modifier.fillMaxWidth(.85f).padding(vertical=15.dp).padding(horizontal=10.dp)){
                            Text(text = expense.category)
                            Text(text = expense.amount + "₽ ")
                        }
                        IconButton(onClick = {
                            expenseViewModel.removeExpense(expense)
                            navController.navigate("/expense-list")}
                        ) {
                            Icon(
                                Icons.Rounded.Delete,
                                contentDescription = null
                            )
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            Row (modifier = Modifier, horizontalArrangement = Arrangement.Center) {
                Button(modifier = Modifier
                    .fillMaxWidth()
                    ,onClick = { navController.navigate("/add-expense")}) {
                    Text(text = "Добавить запись")
                }
            }
            Row(horizontalArrangement = Arrangement.Center) {
                Button(modifier = Modifier
                    .fillMaxWidth(),
                    onClick = { navController.navigate("/expense-statistic")}) {
                    Text(text = "Статистика рассходов")
                }
            }

        }
    }
}
