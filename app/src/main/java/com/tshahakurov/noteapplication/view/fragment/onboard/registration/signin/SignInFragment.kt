package com.tshahakurov.noteapplication.view.fragment.onboard.registration.signin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.tshahakurov.noteapplication.R
import com.tshahakurov.noteapplication.databinding.FragmentSigninBinding

class SignInFragment : Fragment() {

    private var _binding: FragmentSigninBinding? = null
    private val binding get() = _binding!!

    private val viewModel: SignInViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSigninBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {

            firstNameInputMain.addTextChangedListener {
                viewModel.firstName.value = it.toString()
            }
            lastNameInputMain.addTextChangedListener {
                viewModel.lastName.value = it.toString()
            }
            emailInputMain.addTextChangedListener {
                viewModel.email.value = it.toString()
            }
            passwordInputMain.addTextChangedListener {
                viewModel.password.value = it.toString()
            }


            signInButton.setOnClickListener {
                if (viewModel.validateUser()) {
                    Toast.makeText(
                        requireContext(),
                        R.string.sign_in_successful,
                        Toast.LENGTH_SHORT
                    ).show()
                    findNavController().navigate(
                        R.id.action_signInFragment_to_mainFragment
                    )

                } else {
                    passwordInputMain.setText("")
                    Toast
                        .makeText(requireContext(), R.string.registration_error, Toast.LENGTH_SHORT)
                        .show()
                }
            }

            loginButtonText.setOnClickListener {
                findNavController().popBackStack()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}