package com.example.ecommerce.ui.fragment.detail

import android.graphics.Paint
import android.os.Bundle
import android.util.Log

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.ecommerce.R
import com.example.ecommerce.model.Amazing
import com.example.ecommerce.ui.fragment.home.ImageLoading
import com.example.ecommerce.utils.Fragment
import com.example.ecommerce.viewmodel.DetailProductViewModel
import kotlinx.android.synthetic.main.fragment_detail_product.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf


class DetailProductFragment : Fragment() {
    private val detailProductViewModel: DetailProductViewModel by viewModel { parametersOf(id) }
    private val imageLoading: ImageLoading by inject()
    var args: DetailProductFragmentArgs? = null
    var id: Int? = null
    val amazing: Amazing? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail_product, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        args = arguments?.let { DetailProductFragmentArgs.fromBundle(it) }
        id = args?.amazing?.id
        detailProductViewModel.detailProductLiveData.observe(viewLifecycleOwner) {
            imageLoading.load(image, it.Images[0].image)
            ("name : " + it.Product[0].title).also { name -> title.text = name }
            rating.rating = it.Product[0].score
            ("warranty : " + it.Product[0].warranty).also { warranty ->
                warranty_text.text = warranty
            }
            ("club : " + it.Product[0].club).also { cl -> club.text = cl }
            ("$" + it.Product[0].price.toString()).also { p -> price.text = p }
            ("$" + it.Product[0].offer.toString()).also { o -> offer.text = o }
            price.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
            ("description : " + it.Product[0].description).also { int -> introduction.text = int }
            ("available colors : " + it.Product[0].color).also { color -> color_text.text = color }
            ("detail : " + it.Product[0].detail).also { de -> detail.text = de }
        }
        detailProductViewModel.progressbarLiveData.observe(viewLifecycleOwner) {
            progress(it)
        }
        technical_specifications.setOnClickListener {
            val directions =
                amazing?.let { it1 ->
                    DetailProductFragmentDirections.actionDetailProductFragmentToPropertyFragment(
                        it1
                    )
                }
            directions?.let { it1 -> it.findNavController().navigate(it1) }
        }

    }


}