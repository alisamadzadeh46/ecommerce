package com.example.ecommerce.ui.fragment.account

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.navigation.fragment.findNavController
import com.example.ecommerce.R
import com.example.ecommerce.utils.Fragment
import com.example.ecommerce.utils.TokenHolder
import com.example.ecommerce.viewmodel.LoginViewModel
import kotlinx.android.synthetic.main.fragment_login.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import www.sanju.motiontoast.MotionToast


class LoginFragment : Fragment() {
    private val loginViewModel: LoginViewModel by viewModel()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (TokenHolder.access_token!=null){
            findNavController().navigate(R.id.profileFragment)
        }

        login_button.setOnClickListener {
            val username = username.text.toString()
            val password =
                password.text.toString()
            loginViewModel.login(username, password)
        }
        register.setOnClickListener {
            findNavController().navigate(R.id.registerFragment)
        }
        loginViewModel.loginLiveData.observe(viewLifecycleOwner) {
            MotionToast.createToast(
                requireContext() as Activity,
                "Hurray success 😍",
                "You have successfully logged in!",
                MotionToast.TOAST_SUCCESS,
                MotionToast.GRAVITY_BOTTOM,
                MotionToast.LONG_DURATION,
                ResourcesCompat.getFont(requireContext() as Activity, R.font.helvetica_regular)
            )
            findNavController().navigate(R.id.profileFragment)


        }
        loginViewModel.loginErrorLiveData.observe(viewLifecycleOwner){
            MotionToast.darkColorToast(
                requireContext() as Activity,
                "Failed ",
                it.toString(),
                MotionToast.TOAST_ERROR,
                MotionToast.GRAVITY_BOTTOM,
                MotionToast.LONG_DURATION,
                ResourcesCompat.getFont(requireContext() as Activity, R.font.helvetica_regular)
            )
        }
        loginViewModel.progressbarLiveData.observe(viewLifecycleOwner) {
            progress(it)
        }

    }


}