package com.example.listoffruits.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.listoffruits.data.model.FruitModel
import com.example.listoffruits.domain.GetAllFruitsUseCase
import androidx.lifecycle.viewModelScope
import com.example.listoffruits.domain.GetFruitByNameUseCase
import kotlinx.coroutines.launch

class FruitViewModel : ViewModel() {

    val fruitModelAll = MutableLiveData<MutableList<FruitModel>>()
    val fruitModelByName = MutableLiveData<FruitModel>()
    private val getAllFruitsUseCase = GetAllFruitsUseCase()
    private val getFruitByNameUseCase = GetFruitByNameUseCase()

    fun getAllFruits() {
        viewModelScope.launch {
            val result: MutableList<FruitModel> = getAllFruitsUseCase.invoke()
            if (!result.isNullOrEmpty()) {
                fruitModelAll.postValue(result)
            } else {
                fruitModelAll.postValue(mutableListOf())
            }
        }
    }

    fun getFruitByName(nameFruit: String) {
        viewModelScope.launch {
            val result: FruitModel = getFruitByNameUseCase.invoke(nameFruit)
            fruitModelByName.postValue(result)
        }
    }
}