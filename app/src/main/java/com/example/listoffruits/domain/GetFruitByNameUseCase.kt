package com.example.listoffruits.domain

import com.example.listoffruits.data.model.FruitModel
import com.example.listoffruits.data.network.FruitServicie

class GetFruitByNameUseCase {

    private val service = FruitServicie()

    suspend fun invoke(nameFruit:String): FruitModel = service.getFruitByName(nameFruit)
}