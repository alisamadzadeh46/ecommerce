package com.example.ecommerce.ui.fragment.account

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ecommerce.R
import com.example.ecommerce.ui.adapter.AdapterListFavorite
import com.example.ecommerce.ui.adapter.CategoryAdapter
import com.example.ecommerce.utils.Fragment
import com.example.ecommerce.utils.TokenHolder
import com.example.ecommerce.viewmodel.FavoriteListViewModel
import kotlinx.android.synthetic.main.fragment_favorite.*
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf


class FavoriteFragment : Fragment() {
    private val listFavoriteViewModel: FavoriteListViewModel by viewModel()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favorite, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listFavoriteViewModel.listFavorite(
            "Bearer ${TokenHolder.access_token}"
        )

        listFavoriteViewModel.favoriteListLiveData.observe(viewLifecycleOwner) {
            val adapterListFavorite: AdapterListFavorite by inject { parametersOf(it) }
            RecyclerViewList.adapter = adapterListFavorite
        }
        listFavoriteViewModel.progressbarLiveData.observe(viewLifecycleOwner) {
            progress(it)
        }
        RecyclerViewList.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }


}