package com.example.ecommerce.ui.fragment.comparison

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ecommerce.R
import com.example.ecommerce.ui.adapter.ComparisonAdapter
import com.example.ecommerce.utils.Fragment
import com.example.ecommerce.viewmodel.DetailProductViewModel
import com.example.ecommerce.viewmodel.PropertyProductViewModel
import kotlinx.android.synthetic.main.fragment_comparison_list.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf


class ComparisonFragment : Fragment() {
    private val propertyProductViewModel: PropertyProductViewModel by viewModel { parametersOf(id) }
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
        propertyProductViewModel.propertyProductLiveData.observe(viewLifecycleOwner) {
            val comparisonAdapter:ComparisonAdapter by inject { parametersOf(it) }
            recyclerview_comparison.adapter = comparisonAdapter
        }
        propertyProductViewModel.progressbarLiveData.observe(viewLifecycleOwner) {
            progress(it)
        }
        recyclerview_comparison.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }


}