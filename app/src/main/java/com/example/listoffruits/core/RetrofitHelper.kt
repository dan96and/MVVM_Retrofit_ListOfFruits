package com.example.listoffruits.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//Object de Retrofit donde tendremos la base de la URL
object RetrofitHelper {
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://fruityvice.com/api/fruit/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}