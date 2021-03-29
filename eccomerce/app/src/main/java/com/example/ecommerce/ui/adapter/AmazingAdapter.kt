package com.example.ecommerce.ui.adapter

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerce.R
import com.example.ecommerce.model.Amazing
import com.example.ecommerce.ui.fragment.home.ImageLoading
import kotlinx.android.synthetic.main.amazing_item.view.*

class AmazingAdapter(private val amazing: List<Amazing>, private val imageLoading: ImageLoading) :
    RecyclerView.Adapter<AmazingAdapter.AmazingViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AmazingViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.amazing_item, parent, false)
        return AmazingViewHolder(view)
    }

    override fun onBindViewHolder(holder: AmazingViewHolder, position: Int) {
        val amazing = amazing[position]
        holder.bind(amazing, imageLoading)
    }

    override fun getItemCount(): Int = amazing.size


    class AmazingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(amazing: Amazing, imageLoading: ImageLoading) {
            itemView.apply {
                imageLoading.load(amazing_image, amazing.image)
                amazing_text.text = amazing.title
                (" $" + amazing.price.toString()).also { price.text = it }
                (" $" + amazing.offer.toString()).also { offer.text = it }
                offer.paintFlags=Paint.STRIKE_THRU_TEXT_FLAG
                (amazing.amount.toString() + " % ").also { amount.text = it }
            }
        }
    }
}