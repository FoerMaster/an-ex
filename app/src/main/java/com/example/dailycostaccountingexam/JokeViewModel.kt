package com.example.dailycostaccountingexam

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dailycostaccountingexam.data.Joke
import com.example.dailycostaccountingexam.network.JokeAPIService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class JokeViewModel : ViewModel() {
    private val _joke = MutableStateFlow<Joke?>(null)
    val joke: StateFlow<Joke?> = _joke.asStateFlow()

    fun loadJoke() {
        viewModelScope.launch {
            try {
                val joke = JokeAPIService.create().getRandomJoke()
                _joke.value = joke
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}