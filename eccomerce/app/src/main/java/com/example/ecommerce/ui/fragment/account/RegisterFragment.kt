package com.example.ecommerce.ui.fragment.account

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import com.example.ecommerce.R
import com.example.ecommerce.utils.Fragment
import com.example.ecommerce.viewmodel.RegisterViewModel
import kotlinx.android.synthetic.main.fragment_register.*
import kotlinx.android.synthetic.main.fragment_register.password
import kotlinx.android.synthetic.main.fragment_register.username
import org.koin.androidx.viewmodel.ext.android.viewModel
import www.sanju.motiontoast.MotionToast


class RegisterFragment : Fragment() {
    private val registerViewModel: RegisterViewModel by viewModel()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /* get text and change to string username */
        /* get text and change to string password and no need set repetition password or password2 in android. handle using server  */
        register_button.setOnClickListener {
            val username = username.text.toString()
            val password =
                password.text.toString()
            registerViewModel.login(username, password, password)
        }

        registerViewModel.registerLiveData.observe(viewLifecycleOwner) {
            MotionToast.darkColorToast(
                requireContext() as Activity,
                "Hurray success 😍",
                "You have successfully registered!",
                MotionToast.TOAST_SUCCESS,
                MotionToast.GRAVITY_BOTTOM,
                MotionToast.LONG_DURATION,
                ResourcesCompat.getFont(requireContext() as Activity,R.font.helvetica_regular))
        }
        registerViewModel.progressbarLiveData.observe(viewLifecycleOwner) {
            progress(it)
        }
    }


}