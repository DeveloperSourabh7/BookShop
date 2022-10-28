package com.sourabh.bookshop.ui.login.signup


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.sourabh.bookshop.R
import com.sourabh.bookshop.common.showSnackbar
import com.sourabh.bookshop.databinding.FragmentSignUpBinding
import com.sourabh.bookshop.viewModel.SignUpFragmentViewModel

class SignUpFragment : Fragment() {

    private var _binding: FragmentSignUpBinding? = null
    private val binding get() = _binding!!

    private val viewModel by lazy { SignUpFragmentViewModel() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_sign_up, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.signUpFragmentObject = this
        initObservers()
    }

    private fun initObservers() {

        with(binding) {

            with(viewModel) {

                 isInfosValid.observe(viewLifecycleOwner) {
                     Log.e("Inside SignUp Fragment ","IsValid is working fine")

                     if (it.not()) showSnackbar(
                        requireView(),
                        R.string.incomplete_information_entered
                    )
                }

                isValidMail.observe(viewLifecycleOwner) {
                    if (it.not()) {
                        tilEmail.error = getString(R.string.invalid_mail)
                    } else {
                        tilEmail.error = ""
                    }
                }

                isPasswordMatch.observe(viewLifecycleOwner) {
                    if (it.not()) {
                        tilPassword.error = getString(R.string.password_match_error)
                        tilCnfPassword.error = getString(R.string.password_match_error)
                    } else {
                        tilPassword.error = ""
                        tilCnfPassword.error = ""
                    }
                }

                isSignUp.observe(viewLifecycleOwner) {
                    if (it) {
                        showSnackbar(requireView(), R.string.sign_up_snack_text)
                        clearFields()
                    } else {
                        tilEmail.error = getString(R.string.registered_mail)
                    }
                }
            }
        }
    }

    fun signUpButton(
        email: String,
        fullName: String,
        phoneNumber: String,
        password: String,
        confirmPassword: String,
    ) {
        Log.e("Inside SignUp Fragment ","Email is working fine")
        viewModel.signUp(email, fullName, phoneNumber, password, confirmPassword )
    }

    private fun clearFields() {
        with(binding) {
            edEmail.setText("")
            tilEmail.error = ""
            edPassword.setText("")
            tilPassword.error = ""
            edCnfPassword.setText("")
            tilCnfPassword.error = ""
            edFullname.setText("")
            tilFullname.error = ""
            edMobile.setText("")
            tilMobile.error = ""
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}