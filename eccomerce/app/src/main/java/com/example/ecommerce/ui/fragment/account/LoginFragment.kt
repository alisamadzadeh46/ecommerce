package com.example.ecommerce.ui.fragment.account

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.ecommerce.R
import com.example.ecommerce.utils.Fragment
import com.example.ecommerce.viewmodel.LoginViewModel
import kotlinx.android.synthetic.main.fragment_login.*
import org.koin.androidx.viewmodel.ext.android.viewModel


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
          /* get text and change to string username */
          /* get text and change to string password and no need set repetition password or password2 in android. handle using server  */
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
            Log.i("LOG", "${it.access_token}")
        }
        loginViewModel.progressbarLiveData.observe(viewLifecycleOwner) {
            progress(it)
        }

    }


}