package com.example.ecommerce.ui.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.ecommerce.model.Image
import com.example.ecommerce.ui.fragment.SliderDetailFragment

class SliderAdapterDetailProduct(val fragment: Fragment, val image: List<Image>) :  FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = image.size
    override fun createFragment(position: Int) = SliderDetailFragment.newInstance(image[position])
}