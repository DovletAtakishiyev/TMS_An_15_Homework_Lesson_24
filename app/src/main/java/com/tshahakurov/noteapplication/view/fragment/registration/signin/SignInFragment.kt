package com.tshahakurov.noteapplication.view.fragment.registration.signin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import com.tshahakurov.noteapplication.R
import com.tshahakurov.noteapplication.databinding.FragmentSigninBinding
import com.tshahakurov.noteapplication.util.replaceFragment
import com.tshahakurov.noteapplication.view.fragment.book.list.NoteListFragment
import com.tshahakurov.noteapplication.view.fragment.registration.login.LoginFragment

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

            loginButtonText.setOnClickListener {
                parentFragmentManager.replaceFragment(
                    R.id.fragmentContainer, LoginFragment()
                )
            }

            signInButton.setOnClickListener {
                if (viewModel.validateUser()){
                    Toast.makeText(requireContext(), R.string.sign_in_successful, Toast.LENGTH_SHORT)
                        .show()
                    parentFragmentManager.replaceFragment(
                        R.id.fragmentContainer, NoteListFragment()
                    )
                } else {
                    passwordInputMain.setText("")
                    Toast.makeText(requireContext(), "Something went wrong", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}