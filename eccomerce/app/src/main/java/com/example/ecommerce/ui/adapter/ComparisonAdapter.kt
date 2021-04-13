package com.example.ecommerce.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerce.R
import com.example.ecommerce.model.Property
import kotlinx.android.synthetic.main.item_comparison.view.*
import kotlinx.android.synthetic.main.item_property_product.view.text_title

const val ITEM_TITLE = 1
const val ITEM_VALUE = 2

class ComparisonAdapter(val property: List<Property>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == ITEM_TITLE) ComparisonTitleViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_property_product, parent, false)
        ) else ComparisonViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_comparison, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val property = property[position]
        if (getItemViewType(position) == ITEM_TITLE) {
            (holder as ComparisonTitleViewHolder).bind(property)
        } else {
            (holder as ComparisonViewHolder).bind(property)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (property[position].value == "") {
            ITEM_TITLE
        } else {
            ITEM_VALUE
        }
    }

    override fun getItemCount(): Int = property.size

    class ComparisonTitleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(property: Property) {
            itemView.apply {
                text_title.text = property.title

            }
        }
    }

    class ComparisonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(property: Property) {
            itemView.apply {
                text_one.text = property.title
                text_two.text = property.value

            }
        }
    }


}