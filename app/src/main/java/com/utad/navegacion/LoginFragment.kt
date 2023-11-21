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

    private lateinit var checkBoxAll: CheckBox
    private lateinit var checkBoxSports: CheckBox
    private lateinit var checkBoxTechnology: CheckBox
    private lateinit var etName: EditText
    private lateinit var btnContinue: Button
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
        initComponents()
        checkValue()
        checkInformation()

    }

    private fun checkInformation() {
        btnContinue.setOnClickListener {
            if ((checkBoxAll.isChecked || checkBoxSports.isChecked || checkBoxTechnology.isChecked) && !etName.text.toString()
                    .isNullOrEmpty()
            ) {
                navigateToWelcome()
            } else {
                Toast.makeText(requireContext(), "Faltan completar datos", Toast.LENGTH_SHORT).show()
            }
        }
    }


    private fun checkValue() {
        checkBoxAll.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                checkBoxSports.isChecked = false
                checkBoxTechnology.isChecked = false
                categoryValue = checkBoxAll.text.toString()
                binding.btnContinue.isEnabled = true
            } else {
                binding.btnContinue.isEnabled = false
            }
        }

        checkBoxSports.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                checkBoxAll.isChecked = false
                checkBoxTechnology.isChecked = false
                categoryValue = checkBoxSports.text.toString()
                binding.btnContinue.isEnabled = true
            } else {
                binding.btnContinue.isEnabled = false
            }
        }

        checkBoxTechnology.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                checkBoxAll.isChecked = false
                checkBoxSports.isChecked = false
                categoryValue = checkBoxTechnology.text.toString()
                binding.btnContinue.isEnabled = true
            } else {
                binding.btnContinue.isEnabled = false
            }

        }
    }

    private fun initComponents() {
        checkBoxAll = binding.cbAll
        checkBoxSports = binding.cbSports
        checkBoxTechnology = binding.cbTechnology
        etName = binding.etName
        btnContinue = binding.btnContinue


    }


    private fun navigateToWelcome() {
        nameValue = etName.text.toString()
        nameValue = nameValue.toLowerCase().capitalize()
        val bundle =Bundle() // Cro un bundle
        bundle.putString("name",nameValue) // inserto los datos
        bundle.putString("category",categoryValue)
        parentFragmentManager.setFragmentResult("result",bundle) // le añado el bundle al parent manager para poder leerlo en el main
        val fragment = WelcomeFragment()
        val transaction = parentFragmentManager.beginTransaction()
        transaction.setReorderingAllowed(true)
            .replace(R.id.fcv_login, fragment)
            .setTransition(TRANSIT_FRAGMENT_FADE)
            .commit()
    }


}