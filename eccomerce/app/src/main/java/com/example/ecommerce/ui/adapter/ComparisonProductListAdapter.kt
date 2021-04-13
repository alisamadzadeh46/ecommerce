package com.example.ecommerce.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerce.R
import com.example.ecommerce.model.Product
import com.example.ecommerce.ui.fragment.comparison.ComparisonListFragment
import com.example.ecommerce.ui.fragment.comparison.ComparisonListFragmentDirections
import com.example.ecommerce.ui.fragment.home.ImageLoading
import com.example.ecommerce.utils.ChangeNumber
import kotlinx.android.synthetic.main.item_comparison_product_list.view.*
import java.util.ArrayList

class ComparisonProductListAdapter(private val imageLoading: ImageLoading) :
    RecyclerView.Adapter<ComparisonProductListAdapter.ComparisonProductListViewHolder>() {
    var product = ArrayList<Product>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ComparisonProductListViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(
                    R.layout.item_comparison_product_list,
                    parent,
                    false
                )
        return ComparisonProductListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ComparisonProductListViewHolder, position: Int) {
        val product = product[position]
        holder.bind(product, imageLoading)
    }

    override fun getItemCount(): Int = product.size


    class ComparisonProductListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(product: Product, imageLoading: ImageLoading) {
            itemView.apply {
                setOnClickListener {
                    findNavController().navigate(
                        ComparisonListFragmentDirections.actionComparisonListFragmentToComparisonFragment(
                            product
                        )
                    )
                }
                imageLoading.load(imageView, product.image)
                text_title.text = product.title
                (" $ " + ChangeNumber().format(product.price)).also { text_price.text = it }
            }
        }
    }
}