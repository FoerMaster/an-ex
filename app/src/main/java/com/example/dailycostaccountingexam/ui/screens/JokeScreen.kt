package com.example.dailycostaccountingexam.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.dailycostaccountingexam.JokeViewModel

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun JokeScreen(jokeViewModel: JokeViewModel = viewModel()) {
    val joke = jokeViewModel.joke.value

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.Transparent,
        border = BorderStroke(width = 1.dp,color=Color.Gray)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(5.dp)
        ) {
            if (joke != null) {
                Text(text = joke.setup)
                Text(text = joke.punchline)
            } else {
                Text(text = "Ошибка загрузки крутой шутки, возможно проблемы с сервером или интернетом.")
            }
        }
    }

    LaunchedEffect(jokeViewModel) {
        jokeViewModel.loadJoke()
    }
}