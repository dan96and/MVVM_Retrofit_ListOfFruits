package com.example.listoffruits.data.network

import com.example.listoffruits.core.RetrofitHelper
import com.example.listoffruits.data.model.FruitModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

//Hacemos la llamada a la API donde devolvera la respuesta o una lista vacia si devuelve null
class FruitServicie {

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getAllFruits(): List<FruitModel> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(FruitApiClient::class.java).getAllFruits()
            response.body() ?: emptyList()
        }
    }
}