package com.example.listoffruits.ui.view

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.listoffruits.databinding.ActivityMainBinding
import com.example.listoffruits.ui.viewmodel.FruitViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val fruitViewModel: FruitViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fruitViewModel.getAllFruits()

        fruitViewModel.fruitModel.observe(this) {
            Log.v("Pene",it.toString())
        }
    }
}