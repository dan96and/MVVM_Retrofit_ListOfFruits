package com.example.listoffruits.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.listoffruits.R
import com.example.listoffruits.data.model.FruitModel
import com.example.listoffruits.databinding.CardViewFruitsBinding

class AdapterFruit(private var listFruits: MutableList<FruitModel>) :
    RecyclerView.Adapter<AdapterFruit.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.card_view_fruits, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listFruits[position])
    }

    override fun getItemCount(): Int = listFruits.size

    class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        private val binding = CardViewFruitsBinding.bind(view)

        fun bind(item: FruitModel) {
            with(binding) {
                tvId.text = item.id.toString()
                tvGenus.text = item.genus
                tvName.text = item.name
                tvFamily.text = item.family
                tvOrder.text = item.order
            }

        }
    }
}

