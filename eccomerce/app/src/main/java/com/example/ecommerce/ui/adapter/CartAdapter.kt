package com.example.ecommerce.ui.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerce.model.AddCart
import com.example.ecommerce.ui.fragment.home.ImageLoading


class CartAdapter(
    private val cart: List<AddCart>,
    imageLoading: ImageLoading
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    override fun getItemCount(): Int = cart.size


    class PurchaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    class CartItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

}