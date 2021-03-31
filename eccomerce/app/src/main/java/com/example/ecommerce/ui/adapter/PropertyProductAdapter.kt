package com.example.ecommerce.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerce.R
import com.example.ecommerce.model.Property
import kotlinx.android.synthetic.main.item_property_product.view.text_title
import kotlinx.android.synthetic.main.item_property_product_child.view.*

const val PROPERTY_ITEM = 1
const val PROPERTY_ITEM_CHILD = 2

class PropertyProductAdapter(private val property: List<Property>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == PROPERTY_ITEM) {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_property_product, parent, false)
            PropertyViewHolder(view)
        } else {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_property_product_child, parent, false)
            PropertyChildViewHolder(view)
        }

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val property = property[position]
        if (getItemViewType(position) == PROPERTY_ITEM) {
            (holder as PropertyViewHolder).bind(property)
        } else {
            (holder as PropertyChildViewHolder).bind(property)
        }

    }

    override fun getItemViewType(position: Int): Int {
        return if (property[position].value == "") {
            PROPERTY_ITEM
        } else {
            PROPERTY_ITEM_CHILD
        }
    }

    override fun getItemCount(): Int = property.size


    class PropertyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(property: Property) {
            itemView.apply {
                text_title.text = property.title
            }
        }
    }

    class PropertyChildViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(property: Property) {
            itemView.apply {
                text_title.text = property.title
                text_value.text = property.value

            }
        }
    }


}