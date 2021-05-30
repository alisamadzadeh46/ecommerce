package com.example.ecommerce.ui.fragment.detail


import android.app.Activity
import android.graphics.Paint
import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ecommerce.R
import com.example.ecommerce.ui.adapter.AdapterRatingProduct
import com.example.ecommerce.ui.adapter.SliderAdapterDetailProduct
import com.example.ecommerce.utils.ChangeNumber
import com.example.ecommerce.utils.Fragment
import com.example.ecommerce.utils.TokenHolder
import com.example.ecommerce.viewmodel.AddFavoriteViewModel
import com.example.ecommerce.viewmodel.DetailProductViewModel
import com.example.ecommerce.viewmodel.LoginViewModel

import kotlinx.android.synthetic.main.fragment_detail_product.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf
import www.sanju.motiontoast.MotionToast


class DetailProductFragment : Fragment() {
    private val detailProductViewModel: DetailProductViewModel by viewModel { parametersOf(id) }
    private val loginViewModel: LoginViewModel by viewModel()
    private val addFavoriteViewModel: AddFavoriteViewModel by viewModel()
    private var args: DetailProductFragmentArgs? = null
    var id: Int? = null
    val product: String? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail_product, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        args = arguments?.let { DetailProductFragmentArgs.fromBundle(it) }
        id = args?.product?.id
        close_image.setOnClickListener {
            it.findNavController().popBackStack()
        }
        more_image.setOnClickListener {
            it.findNavController().navigate(
                DetailProductFragmentDirections.actionDetailProductFragmentToBottomSheetDialogFragment2(
                    args?.product!!
                )
            )

        }
        favorite_image.setOnClickListener {
            if (loginViewModel.checkLoginStatus.value == false) {
                it.findNavController().navigate(R.id.action_detailProductFragment_to_loginFragment2)
            } else {
                id?.let { it1 ->
                    addFavoriteViewModel.addFavorite(
                        it1,
                        "Bearer ${TokenHolder.access_token}"
                    )
                }
            }
        }
        addFavoriteViewModel.addFavoriteLiveData.observe(viewLifecycleOwner) {
            if (it.is_favorite) {
                MotionToast.createToast(
                    requireContext() as Activity,
                    "Hurray success 😍",
                    "Add to favorite!",
                    MotionToast.TOAST_SUCCESS,
                    MotionToast.GRAVITY_BOTTOM,
                    MotionToast.LONG_DURATION,
                    ResourcesCompat.getFont(requireContext() as Activity, R.font.helvetica_regular),
                )
                favorite_image.setImageResource(R.drawable.ic_round_favorite_24)
            }
            if (it.available == "product is favorite") {
                MotionToast.createToast(
                    requireContext() as Activity,
                    "available ☹",
                    "product is favorite !",
                    MotionToast.TOAST_WARNING,
                    MotionToast.GRAVITY_BOTTOM,
                    MotionToast.LONG_DURATION,
                    ResourcesCompat.getFont(requireContext() as Activity, R.font.helvetica_regular),
                )
                favorite_image.setImageResource(R.drawable.ic_round_favorite_24)
            }
        }

        detailProductViewModel.detailProductLiveData.observe(viewLifecycleOwner) {
            ("name : " + it.Product[0].title).also { name -> title.text = name }
            rating.rating = it.Product[0].score
            ("warranty : " + it.Product[0].warranty).also { warranty ->
                warranty_text.text = warranty
            }
            ("club : " + it.Product[0].club).also { cl -> club.text = cl }
            ("$" + ChangeNumber().format(it.Product[0].price)).also { p -> price.text = p }
            ("$" + ChangeNumber().format(it.Product[0].offer)).also { o -> offer.text = o }
            price.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
            ("description : " + it.Product[0].description).also { int -> introduction.text = int }
            ("available colors : " + it.Product[0].color).also { color -> color_text.text = color }
            ("detail : " + it.Product[0].detail).also { de -> detail.text = de }
            val sliderAdapter = SliderAdapterDetailProduct(this, it.Images)
            image.adapter = sliderAdapter
            dots_indicator_detail.setViewPager2(image)
        }
        detailProductViewModel.progressbarLiveData.observe(viewLifecycleOwner) {
            progress(it)
        }
        detailProductViewModel.ratingProductLiveData.observe(viewLifecycleOwner) {
            val adapterRatingProduct: AdapterRatingProduct by inject { parametersOf(it) }
            recyclerview_rating.adapter = adapterRatingProduct
        }
        technical_specifications.setOnClickListener {
            it.findNavController().navigate(
                DetailProductFragmentDirections.actionDetailProductFragmentToPropertyFragment(
                    args?.product!!
                )
            )
        }
        recyclerview_rating.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

    }



    override fun onResume() {
        super.onResume()
        loginViewModel.checkLogin()
    }
}