package com.tshahakurov.noteapplication.view.fragment.onboard.registration.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.tshahakurov.noteapplication.R
import com.tshahakurov.noteapplication.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {

            emailInputMain.addTextChangedListener {
                viewModel.email.value = it.toString()
            }
            passwordInputMain.addTextChangedListener {
                viewModel.password.value = it.toString()
            }

            loginButton.setOnClickListener {
                // TODO (login validation logic via viewModel)
                findNavController().navigate(
                    R.id.action_loginFragment_to_mainFragment
                )
            }

            signInButtonText.setOnClickListener {
                findNavController().navigate(
                    R.id.action_loginFragment_to_signInFragment
                )
            }
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}