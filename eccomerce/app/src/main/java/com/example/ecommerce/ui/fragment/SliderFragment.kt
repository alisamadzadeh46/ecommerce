package com.example.ecommerce.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.ecommerce.R
import com.example.ecommerce.custom.ImageView
import com.example.ecommerce.model.Slider
import com.example.ecommerce.ui.fragment.home.ImageLoading
import org.koin.android.ext.android.inject

class SliderFragment : Fragment() {
    private val imageLoading: ImageLoading by inject()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val slider = arguments?.getParcelable<Slider>("slider")

        val view = inflater.inflate(R.layout.fragment_slider, container, false)
        slider?.let { imageLoading.load(view as ImageView, it.image) }
        return view
    }

    companion object {
        fun newInstance(slider: Slider): SliderFragment {
            return SliderFragment().apply {
                arguments = Bundle().apply {
                    putParcelable("slider", slider)
                }
            }
        }
    }
}