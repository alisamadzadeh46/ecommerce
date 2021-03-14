package com.example.ecommerce.ui.fragment.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ecommerce.R
import com.example.ecommerce.viewmodel.HomeViewModel
import org.koin.android.ext.android.inject


class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by inject()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeViewModel.sliderLiveData.observe(viewLifecycleOwner) {
            Log.i("LOG", "onViewCreated: $it")
        }
    }


}