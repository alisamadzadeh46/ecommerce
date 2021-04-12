package com.example.ecommerce.ui.adapter

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerce.R
import com.example.ecommerce.model.Amazing
import com.example.ecommerce.ui.fragment.home.HomeFragmentDirections
import com.example.ecommerce.ui.fragment.home.ImageLoading
import com.example.ecommerce.utils.ChangeNumber
import kotlinx.android.synthetic.main.amazing_item.view.*

class AmazingAdapter(private val amazing: List<Amazing>, private val imageLoading: ImageLoading) :
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
        val amazing = amazing[position]
        holder.bind(amazing, imageLoading)
    }

    override fun getItemCount(): Int = amazing.size


    class AmazingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(amazing: Amazing, imageLoading: ImageLoading) {
            itemView.apply {
                setOnClickListener {
                    val directions =
                        HomeFragmentDirections.actionHomeFragmentToDetailProductFragment(amazing)
                    it.findNavController().navigate(directions)
                }
                imageLoading.load(amazing_image, amazing.image)
                amazing_text.text = amazing.title
                (" $" + ChangeNumber().format(amazing.price)).also { price.text = it }
                (" $" + ChangeNumber().format(amazing.offer)).also { offer.text = it }
                offer.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
                (amazing.amount.toString() + " % ").also { amount.text = it }
            }
        }
    }
}