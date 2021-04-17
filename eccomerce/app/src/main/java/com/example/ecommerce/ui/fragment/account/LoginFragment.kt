package com.example.ecommerce.ui.fragment.account

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.ecommerce.R
import com.example.ecommerce.model.Login
import com.example.ecommerce.utils.Fragment
import com.example.ecommerce.utils.Observer
import com.example.ecommerce.utils.singleHelper
import com.example.ecommerce.viewmodel.LoginViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.fragment_login.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class LoginFragment : Fragment() {
    private val loginViewModel: LoginViewModel by viewModel()
    val compositeDisposable = CompositeDisposable()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val username = username.text.toString()  /* get text and change to string username */
        val password =
            password.text.toString()  /* get text and change to string password and no need set repetition password or password2 in android. handle using server  */

        login_button.setOnClickListener {
            loginViewModel.login(username, password, password)
                .singleHelper()
                .subscribe(object : Observer<Login>(compositeDisposable) {
                    override fun onSuccess(t: Login?) {

                    }

                })
        }
        register.setOnClickListener {
            findNavController().navigate(R.id.registerFragment)
        }

    }

    override fun onDestroy() {
        compositeDisposable.clear()
        super.onDestroy()
    }

}