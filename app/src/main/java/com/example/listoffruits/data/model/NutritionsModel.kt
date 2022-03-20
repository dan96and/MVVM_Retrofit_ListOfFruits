package com.example.listoffruits.data.model

import com.google.gson.annotations.SerializedName

data class NutritionsModel(
    @SerializedName("carbohydrates") val carbohydrates: Float,
    @SerializedName("protein") val protein: Float,
    @SerializedName("fat") val fat: Float,
    @SerializedName("calories") val calories: Float,
    @SerializedName("sugar") val sugar: Float
)
