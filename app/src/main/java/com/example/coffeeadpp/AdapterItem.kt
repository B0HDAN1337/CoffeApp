package com.example.coffeeadpp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class AdapterItem (private val dataItem: List<CartItem>,
                   private val listener: OnItemClickListener) : RecyclerView.Adapter<AdapterItem.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val coffeeName: TextView = view.findViewById(R.id.coffeeName)
        val coffeeDescription: TextView = view.findViewById(R.id.coffeeDescription)
        val coffeeAddBtn: ImageButton

        init {
            coffeeAddBtn = view.findViewById(R.id.buttonAddCoffee)
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.menu_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val coffee = dataItem[position]
        holder.coffeeName.text = "${coffee.name} .................... ${coffee.price}"
        holder.coffeeDescription.text = coffee.description

        holder.coffeeAddBtn.setOnClickListener{
            listener.onAddToCartClick(coffee)
        }
    }



    override fun getItemCount(): Int {
        return dataItem.size
    }
}