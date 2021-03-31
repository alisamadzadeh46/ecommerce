package com.example.ecommerce.ui.fragment.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ecommerce.R
import com.example.ecommerce.utils.Fragment
import com.example.ecommerce.viewmodel.PropertyProductViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf


class PropertyFragment : Fragment() {
    private val propertyProductViewModel: PropertyProductViewModel by viewModel { parametersOf(id) }
    var args: PropertyFragmentArgs? = null
    var id: Int? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_property, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        args = arguments?.let { PropertyFragmentArgs.fromBundle(it) }
        id = args?.amazing?.id
    }
}








