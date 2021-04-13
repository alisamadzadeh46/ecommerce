package com.example.ecommerce.ui.fragment.comparison

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ecommerce.R
import com.example.ecommerce.utils.Fragment
import com.example.ecommerce.viewmodel.DetailProductViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf


class ComparisonFragment : Fragment() {
    private val detailProductViewModel: DetailProductViewModel by viewModel { parametersOf(id) }
    var args: ComparisonFragmentArgs? = null
    var id: Int? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_comparison, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        args = arguments?.let { ComparisonFragmentArgs.fromBundle(it) }
        id = args?.product?.id
        detailProductViewModel.detailProductLiveData.observe(viewLifecycleOwner) {

        }
        detailProductViewModel.progressbarLiveData.observe(viewLifecycleOwner) {
            progress(it)
        }
    }


}