package com.example.ecommerce.ui.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerce.R
import com.example.ecommerce.model.AddCart
import com.example.ecommerce.ui.fragment.home.ImageLoading
import kotlinx.android.synthetic.main.cart_item.view.*
import kotlinx.android.synthetic.main.cart_item.view.total
import kotlinx.android.synthetic.main.purchase_summary_item.view.*

const val CART_ITEM = 0
const val PURCHASE_ITEM = 1

class CartAdapter(
    private val cart: List<AddCart>,
    private val imageLoading: ImageLoading
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == CART_ITEM) CartItemViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.cart_item, parent, false)
        ) else {
            PurchaseViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.purchase_summary_item, parent, false)
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val cart = cart[position]
        if (getItemViewType(position) == CART_ITEM) {
            (holder as CartItemViewHolder).bind(cart, imageLoading)
        } else {
            (holder as PurchaseViewHolder).bind(cart, imageLoading)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == cart.size) {
            PURCHASE_ITEM
        } else {
            CART_ITEM
        }
    }


    override fun getItemCount(): Int = (cart.size) + 1


    class PurchaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(
            cart: AddCart,
            imageLoading: ImageLoading
        ) {
            itemView.apply {
                discountText.text = resources.getString(R.string.zero)
                totalText.text = cart.price.toString()
            }
        }
    }

    class CartItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(
            cart: AddCart,
            imageLoading: ImageLoading
        ) {
            itemView.apply {
                imageLoading.load(image, "http://192.168.1.37${cart.product.image}")
                title.text = cart.product.title
                warranty_text.text = cart.product.warranty
                color_text.text = cart.product.color
                total.text = cart.price.toString()
            }
        }
    }

}