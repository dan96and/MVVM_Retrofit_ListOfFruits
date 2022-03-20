package com.example.listoffruits.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.listoffruits.data.model.FruitModel
import com.example.listoffruits.domain.GetAllFruitsUseCase
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class FruitViewModel : ViewModel() {

    val fruitModel = MutableLiveData<List<FruitModel>>()
    private val getAllFruitsUseCase = GetAllFruitsUseCase()

    fun getAllFruits() {
        viewModelScope.launch {
            val result: List<FruitModel> = getAllFruitsUseCase.invoke()
            if (!result.isNullOrEmpty()) {
                fruitModel.postValue(result)
            } else {
                fruitModel.postValue(emptyList())
            }
        }
    }
}