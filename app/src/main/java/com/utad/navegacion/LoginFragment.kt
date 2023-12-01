package com.utad.navegacion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction.TRANSIT_FRAGMENT_FADE
import com.utad.navegacion.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var _binding: FragmentLoginBinding
    private val binding: FragmentLoginBinding get() = _binding

    private lateinit var categoryValue: String
    private lateinit var nameValue: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        checkValue()
        checkInformation()

    }

    private fun checkInformation() {
        binding.btnContinue.setOnClickListener {
            if ((binding.cbAll.isChecked || binding.cbSports.isChecked || binding.cbTechnology.isChecked) && !binding.etName.text.toString()
                    .isNullOrEmpty()
            ) {
                navigateToWelcome()
            } else {
                Toast.makeText(requireContext(), "Faltan completar datos", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    private fun checkValue() {
        binding.cbAll.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                binding.cbSports.isChecked = false
                binding.cbTechnology.isChecked = false
                categoryValue = binding.cbAll.text.toString()
                binding.btnContinue.isEnabled = true
            } else {
                binding.btnContinue.isEnabled = false
            }
        }

        binding.cbSports.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                binding.cbAll.isChecked = false
                binding.cbTechnology.isChecked = false
                categoryValue = binding.cbSports.text.toString()
                binding.btnContinue.isEnabled = true
            } else {
                binding.btnContinue.isEnabled = false
            }
        }

        binding.cbTechnology.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                binding.cbAll.isChecked = false
                binding.cbSports.isChecked = false
                categoryValue = binding.cbTechnology.text.toString()
                binding.btnContinue.isEnabled = true
            } else {
                binding.btnContinue.isEnabled = false
            }

        }
    }


    private fun navigateToWelcome() {
        nameValue = binding.etName.text.toString()
        nameValue = nameValue.toLowerCase().capitalize()
        val bundle = Bundle() // Cro un bundle
        bundle.putString("name", nameValue) // inserto los datos
        bundle.putString("category", categoryValue)
        parentFragmentManager.setFragmentResult(
            "result",
            bundle
        ) // le añado el bundle al parent manager para poder leerlo en el main
        val fragment = WelcomeFragment()
        val transaction = parentFragmentManager.beginTransaction()
        transaction.setReorderingAllowed(true)
            .replace(R.id.fcv_login, fragment)
            .setTransition(TRANSIT_FRAGMENT_FADE)
            .commit()
    }


}