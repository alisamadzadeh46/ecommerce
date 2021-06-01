package com.example.ecommerce.ui.fragment.category

import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ecommerce.R
import com.example.ecommerce.ui.adapter.AdapterCategoryDetail
import com.example.ecommerce.utils.Fragment
import com.example.ecommerce.viewmodel.CategoryDetailViewModel
import kotlinx.android.synthetic.main.fragment_category_list.*
import kotlinx.android.synthetic.main.toolbar.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf


class CategoryListFragment : Fragment() {
    private val categoryDetailProductViewModel: CategoryDetailViewModel by viewModel { parametersOf(id) }
    var args: CategoryListFragmentArgs? = null
    var id: Int? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_category_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        args = arguments?.let { CategoryListFragmentArgs.fromBundle(it) }
        id = args?.id?.id
        image_back.setOnClickListener {
            findNavController().popBackStack()
        }
        text_toolbar.text = getString(R.string.category_list)
        categoryDetailProductViewModel.progressbarLiveData.observe(viewLifecycleOwner) {
            progress(it)
        }
        categoryDetailProductViewModel.categoryDetailLiveData.observe(viewLifecycleOwner) {
            val adapterCategoryDetail: AdapterCategoryDetail by inject { parametersOf(it) }
            category_list.adapter = adapterCategoryDetail
        }
        category_list.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

    }


}