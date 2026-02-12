package com.example.mysimpleapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.mysimpleapp.databinding.SignupBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class Signup : Fragment() {

    private var _binding: SignupBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = SignupBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button4.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
        signIn()
    }

    private fun signIn(){
        val nameText = binding.editTextText.text.toString()
        val emailText = binding.editTextTextEmailAddress2.text.toString()
        val phoneText = binding.editTextPhone.text.toString()
        val passwordText = binding.editTextTextPassword2.text.toString()
        //note: no authentication, this is just a test build.
        binding.registerbtn.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_homeActivity)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}