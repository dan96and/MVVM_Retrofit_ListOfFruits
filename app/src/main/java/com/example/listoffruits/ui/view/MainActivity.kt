package com.example.listoffruits.ui.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listoffruits.adapter.AdapterFruit
import com.example.listoffruits.data.model.FruitModel
import com.example.listoffruits.databinding.ActivityMainBinding
import com.example.listoffruits.ui.viewmodel.FruitViewModel

class MainActivity : AppCompatActivity(), androidx.appcompat.widget.SearchView.OnQueryTextListener {

    private lateinit var binding: ActivityMainBinding

    private val fruitViewModel: FruitViewModel by viewModels()

    private var listFruits: MutableList<FruitModel> = mutableListOf()

    private lateinit var adapterFruits: AdapterFruit


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapterFruits = AdapterFruit(listFruits)
        with(binding.rvListFruits) {
            layoutManager = LinearLayoutManager(context)
            adapter = adapterFruits
        }


        binding.svFruits.setOnQueryTextListener(this)
        fruitViewModel.getAllFruits()

        fruitViewModel.fruitModelAll.observe(this) { it ->
            listFruits.clear()
            listFruits.addAll(it)
            listFruits.sortBy {
                it.id
            }
            adapterFruits.notifyDataSetChanged()
        }

        fruitViewModel.fruitModelByName.observe(this) {
            listFruits.clear()
            listFruits.add(it)
            adapterFruits.notifyDataSetChanged()
        }
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        if (!query.isNullOrEmpty()) {
            fruitViewModel.getFruitByName(query)
        }
            return true
    }

    override fun onQueryTextChange(query: String?): Boolean {

        return true
    }
}