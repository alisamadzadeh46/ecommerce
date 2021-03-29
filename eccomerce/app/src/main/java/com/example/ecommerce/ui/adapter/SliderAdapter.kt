package com.example.ecommerce.ui.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.ecommerce.model.Slider
import com.example.ecommerce.ui.fragment.SliderFragment

class SliderAdapter(val fragment: Fragment, val slider: List<Slider>) :
    FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = slider.size


    override fun createFragment(position: Int) = SliderFragment.newInstance(slider[position])


}