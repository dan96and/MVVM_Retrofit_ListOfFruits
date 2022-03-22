package com.example.listoffruits.data.network

import com.example.listoffruits.data.model.FruitModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

//API Client: En este archivo tendremos las distintas llamadas a la API
interface FruitApiClient {

    @GET("all")
    suspend fun getAllFruits(): Response<MutableList<FruitModel>>

    @GET()
    suspend fun getFruitByName(@Url nameFruit: String): Response<FruitModel>
}