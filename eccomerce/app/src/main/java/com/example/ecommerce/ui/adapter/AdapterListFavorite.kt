package com.example.ecommerce.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerce.R
import com.example.ecommerce.model.FavoriteList
import com.example.ecommerce.ui.fragment.account.FavoriteFragmentDirections
import com.example.ecommerce.ui.fragment.home.ImageLoading
import kotlinx.android.synthetic.main.item_favorite.view.*

class AdapterListFavorite(private val imageLoading: ImageLoading) :
    RecyclerView.Adapter<AdapterListFavorite.ListFavoriteViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListFavoriteViewHolder {
        return ListFavoriteViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_favorite,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(
        holder: ListFavoriteViewHolder,
        position: Int
    ) {
        val list = list[position]
        holder.bind(list, imageLoading)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ListFavoriteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(favoriteList: FavoriteList, imageLoading: ImageLoading) {
            itemView.apply {
                imageLoading.load(imageView, favoriteList.product.image)
                text_title.text = favoriteList.product.title
                findNavController().navigate(
                    FavoriteFragmentDirections.actionFavoriteFragmentToDetailProductFragment2(
                        favoriteList.product
                    )
                )
            }
        }
    }

    private val diffCallback = object : DiffUtil.ItemCallback<FavoriteList>() {
        override fun areContentsTheSame(oldItem: FavoriteList, newItem: FavoriteList): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }

        override fun areItemsTheSame(oldItem: FavoriteList, newItem: FavoriteList): Boolean {
            return oldItem.id == newItem.id
        }
    }
    private val differ = AsyncListDiffer(this, diffCallback)


    var list: List<FavoriteList>
        get() = differ.currentList
        set(value) = differ.submitList(value)
}