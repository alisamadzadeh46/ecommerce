package com.example.ecommerce.ui.adapter

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerce.R
import com.example.ecommerce.model.Product
import com.example.ecommerce.ui.fragment.home.HomeFragmentDirections
import com.example.ecommerce.ui.fragment.home.ImageLoading
import com.example.ecommerce.utils.ChangeNumber
import kotlinx.android.synthetic.main.amazing_item.view.*

class AmazingAdapter(private val product: List<Product>, private val imageLoading: ImageLoading) :
    RecyclerView.Adapter<AmazingAdapter.AmazingViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AmazingViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(
                    R.layout.amazing_item,
                    parent,
                    false
                )
        return AmazingViewHolder(view)
    }

    override fun onBindViewHolder(holder: AmazingViewHolder, position: Int) {
        val amazing = product[position]
        holder.bind(amazing, imageLoading)
    }

    override fun getItemCount(): Int = product.size


    class AmazingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(product: Product, imageLoading: ImageLoading) {
            itemView.apply {
                setOnClickListener {
                    val directions =
                        HomeFragmentDirections.actionHomeFragmentToDetailProductFragment(product)
                    it.findNavController().navigate(directions)
                }
                imageLoading.load(amazing_image, product.image)
                amazing_text.text = product.title
                (" $" + ChangeNumber().format(product.price)).also { price.text = it }
                (" $" + ChangeNumber().format(product.offer)).also { offer.text = it }
                offer.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
                (product.amount.toString() + " % ").also { amount.text = it }
            }
        }
    }
}