package com.example.listoffruits.data.model

import com.google.gson.annotations.SerializedName

data class FruitModel(
    @SerializedName("genus") val genus: String,
    @SerializedName("name") val name: String,
    @SerializedName("id") val id: Int,
    @SerializedName("family") val family: String,
    @SerializedName("order") val order: String,
    @SerializedName("nutritions") val nutritions: NutritionsModel
)