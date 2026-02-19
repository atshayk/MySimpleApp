package com.example.mysimpleapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.fragment.findNavController
import com.example.mysimpleapp.databinding.LoginBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class Login : Fragment() {

    private var _binding: LoginBinding? = null
    private lateinit var loginBtn: Button

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = LoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button3.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
        logIn()
        forgetPassword()
    }

    private fun logIn(){
        val emailText = binding.LoginEmailAddressEditText.text.toString()
        binding.LoginEmailAddressEditText.setText(emailText)
        val passwordText = binding.LoginPasswordEditText.text.toString()
        binding.LoginPasswordEditText.setText(passwordText)
        //note: no authentication, this is just a test build.
        binding.loginbtn.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_homeActivity)
        }
    }

    private fun forgetPassword() {
        Log.d("Forget Password", "Forget Password button clicked")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}