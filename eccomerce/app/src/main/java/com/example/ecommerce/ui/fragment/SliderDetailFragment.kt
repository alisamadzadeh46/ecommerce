package com.example.ecommerce.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ecommerce.R
import com.example.ecommerce.custom.ImageView
import com.example.ecommerce.model.Image
import com.example.ecommerce.ui.fragment.home.ImageLoading
import org.koin.android.ext.android.inject


class SliderDetailFragment : Fragment() {
    private val imageLoading: ImageLoading by inject()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val image = arguments?.getParcelable<Image>("image")
        val view = inflater.inflate(R.layout.fragment_slider_detail, container, false)
        image?.let { imageLoading.load(view as ImageView, it.image) }
        return view
    }

    companion object {
        fun newInstance(image: Image): SliderDetailFragment {
            return SliderDetailFragment().apply {
                arguments = Bundle().apply {
                    putParcelable("image", image)
                }
            }
        }
    }
}