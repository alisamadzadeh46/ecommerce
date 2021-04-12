package com.example.ecommerce.ui.fragment.comparison

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ecommerce.R
import com.example.ecommerce.utils.Fragment
import com.example.ecommerce.viewmodel.ComparisonListViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf


class ComparisonListFragment : Fragment() {
    val comparisonListViewModel: ComparisonListViewModel by viewModel { parametersOf(id) }
    var args: ComparisonListFragmentArgs? = null
    var id: Int? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_comparison_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        args = arguments?.let { ComparisonListFragmentArgs.fromBundle(it) }
        id = args?.amazing?.id
        comparisonListViewModel.comparisonListProductLiveData.observe(viewLifecycleOwner) {

        }
        comparisonListViewModel.progressbarLiveData.observe(viewLifecycleOwner) {
            progress(it)
        }
    }


}