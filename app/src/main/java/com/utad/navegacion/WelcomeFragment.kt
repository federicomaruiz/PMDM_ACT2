package com.utad.navegacion

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import com.utad.navegacion.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {

    private lateinit var _binding: FragmentWelcomeBinding
    private val binding: FragmentWelcomeBinding get() = _binding

    private lateinit var name: String
    private lateinit var category: String


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listenBundle()
        changueSwitch()
        goToHome()

    }

    private fun goToHome() {
        binding.btnFeed.setOnClickListener {
            val intent = Intent(requireContext(), HomeActivity::class.java)
            intent.putExtra("name", name)
            intent.putExtra("category", category)
            startActivity(intent)
        }
    }

    private fun changueSwitch() {
        binding.switch1.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                Toast.makeText(requireContext(), "Confirmas", Toast.LENGTH_SHORT).show()
                binding.btnFeed.isEnabled = true
            } else {
                Toast.makeText(requireContext(), "No confirmas", Toast.LENGTH_SHORT).show()
                binding.btnFeed.isEnabled = false
            }
        }
    }

    /*
        Modifico de forma dinamica parte del texto de bienvenida para añadirle el nombre
    * */
    private fun setName() {
        val welcomeMessage = getString(R.string.tv_title_welcome, name)
        binding.tvWelcome.text = welcomeMessage

    }


    private fun listenBundle() {
        parentFragmentManager.setFragmentResultListener("result", this) { key, bundle ->
            if (bundle.containsKey("name") || bundle.containsKey("category")) {
                name = bundle.getString("name").toString()
                category = bundle.getString("category").toString()
                setName()

            }
        }

    }
}
