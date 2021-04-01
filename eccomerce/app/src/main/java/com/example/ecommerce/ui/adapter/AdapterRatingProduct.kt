package com.example.ecommerce.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerce.R
import com.example.ecommerce.model.Rating
import kotlinx.android.synthetic.main.item_rating.view.*

class AdapterRatingProduct(val rating: List<Rating>) :
    RecyclerView.Adapter<AdapterRatingProduct.RatingProductViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RatingProductViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_rating, parent, false)
        return RatingProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: RatingProductViewHolder, position: Int) {
        val rating = rating[position]
        holder.bind(rating)
    }

    override fun getItemCount(): Int = rating.size


    class RatingProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(rating: Rating) {
            itemView.apply {
                title.text = rating.title
                value.progress = rating.value
            }

        }

    }
}