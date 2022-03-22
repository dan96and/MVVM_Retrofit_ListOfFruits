package com.example.listoffruits.domain

import com.example.listoffruits.data.model.FruitModel
import com.example.listoffruits.data.network.FruitServicie

//En los casos de uso haremos una llamada al servicio
class GetAllFruitsUseCase {

    private val servicie = FruitServicie()

    suspend fun invoke(): MutableList<FruitModel> = servicie.getAllFruits()
}