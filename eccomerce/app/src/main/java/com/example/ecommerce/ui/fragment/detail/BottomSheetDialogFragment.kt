package com.example.ecommerce.ui.fragment.detail


import android.content.Intent
import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ecommerce.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_bottom_sheet_dialog.*


class BottomSheetDialogFragment : BottomSheetDialogFragment() {
    var myView: View? = null
    var args: BottomSheetDialogFragmentArgs? = null
    var title: String? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (myView == null) {
            myView = inflater.inflate(R.layout.fragment_bottom_sheet_dialog, container, false)
        }
        return myView


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        args = arguments?.let { BottomSheetDialogFragmentArgs.fromBundle(it) }
        title = args?.amazing?.title
        text_share.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(
                    Intent.EXTRA_TEXT,
                    "$title : now available in ecommerce"
                )

            }
            startActivity(Intent.createChooser(intent, "Product Name"))
        }

    }


}