package com.example.dailycostaccountingexam.network

import com.example.dailycostaccountingexam.data.Joke
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface JokeAPIService {
    @GET("random_joke")
    suspend fun getRandomJoke(): Joke

    companion object {
        private const val BASE_URL = "https://official-joke-api.appspot.com/"

        fun create(): JokeAPIService {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(JokeAPIService::class.java)
        }
    }
}