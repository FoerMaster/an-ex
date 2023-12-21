package com.example.dailycostaccountingexam.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.dailycostaccountingexam.CategoryViewModel
import com.example.dailycostaccountingexam.data.Category

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddCategoryScreen(categoryViewModel: CategoryViewModel, navController: NavController){

    var category by remember {
        mutableStateOf("")
    }

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.DarkGray)
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 100.dp),
        ){
            Text(
                text = "Добавить категорию",
                modifier =  Modifier,
                textAlign = TextAlign.Center,
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(60.dp, 180.dp)
        ) {
            TextField(
                value = category,
                onValueChange = { category = it},
                placeholder = {
                    Text(
                    text = "Введите категорию",
                    modifier = Modifier
                        .padding(start = 10.dp)
                )})
            Button(
                modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
                enabled = category.isNotEmpty(),
                onClick = {
                    categoryViewModel.addCategory(Category(category))
                    navController.navigate("/add-expense")
                }) {
                Text(text = "Добавить категорию")
            }
        }
    }
}