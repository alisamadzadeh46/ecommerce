package com.example.ecommerce.ui.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerce.model.AddCart

class CartAdapter(private val cart: AddCart) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class PurchaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    class CartItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

}