package com.example.ecommerce.ui.fragment.category

import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.ecommerce.R
import com.example.ecommerce.utils.Fragment
import kotlinx.android.synthetic.main.toolbar.*


class CategoryListFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_category_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        image_back.setOnClickListener {
            findNavController().popBackStack()
        }
        text_toolbar.text = getString(R.string.category_list)
    }


}