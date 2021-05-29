package com.example.ecommerce.ui.fragment.account

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ecommerce.R
import com.example.ecommerce.ui.adapter.AdapterListFavorite
import com.example.ecommerce.utils.Fragment
import com.example.ecommerce.viewmodel.ListFavoriteViewModel
import kotlinx.android.synthetic.main.fragment_favorite.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class FavoriteFragment : Fragment() {
    private val listFavoriteViewModel: ListFavoriteViewModel by viewModel()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listFavoriteViewModel.favoriteListLiveData.observe(viewLifecycleOwner){
            setupRecyclerView()
        }
        listFavoriteViewModel.progressbarLiveData.observe(viewLifecycleOwner) {
            progress(it)
        }
    }

    private fun setupRecyclerView() = RecyclerViewList.apply {
        adapter = AdapterListFavorite
        itemAnimator = null
        layoutManager = LinearLayoutManager(requireContext())
    }
}