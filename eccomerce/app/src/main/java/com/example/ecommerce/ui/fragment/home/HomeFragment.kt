package com.example.ecommerce.ui.fragment.home

import android.os.Bundle
import android.util.Log

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ecommerce.R
import com.example.ecommerce.ui.adapter.SliderAdapter
import com.example.ecommerce.utils.Fragment
import com.example.ecommerce.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModel()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeViewModel.sliderLiveData.observe(viewLifecycleOwner) {
            val sliderAdapter = it?.let { it1 -> SliderAdapter(this, it1) }
            viewpager.adapter = sliderAdapter
            dots_indicator.setViewPager2(viewpager)

        }
        homeViewModel.progressbarLiveData.observe(viewLifecycleOwner) {
            progress(it)
        }

    }


}