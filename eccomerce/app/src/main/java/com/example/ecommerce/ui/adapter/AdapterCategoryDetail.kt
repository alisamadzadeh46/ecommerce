package com.example.ecommerce.ui.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerce.R
import com.example.ecommerce.model.Product
import com.example.ecommerce.ui.fragment.category.CategoryListFragmentDirections
import com.example.ecommerce.ui.fragment.home.ImageLoading
import com.example.ecommerce.utils.ChangeNumber
import kotlinx.android.synthetic.main.category_detail_item.view.*
import kotlinx.android.synthetic.main.category_detail_item.view.price

class AdapterCategoryDetail(
    private val product: List<Product>,
    private val imageLoading: ImageLoading
) :
    RecyclerView.Adapter<AdapterCategoryDetail.ListFavoriteViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListFavoriteViewHolder {
        return ListFavoriteViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.category_detail_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(
        holder: ListFavoriteViewHolder,
        position: Int
    ) {
        val product = product[position]
        holder.bind(product, imageLoading)
    }

    override fun getItemCount(): Int {
        return product.size
    }

    class ListFavoriteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(product: Product, imageLoading: ImageLoading) {
            itemView.apply {
                imageLoading.load(image, product.image)
                text.text = product.title
                (" $" + ChangeNumber().format(product.price)).also { price.text = it }
                setOnClickListener {
                    findNavController().navigate(
                    CategoryListFragmentDirections.actionCategoryListFragmentToDetailProductFragment3(product)
                    )
                }


            }
        }
    }


}