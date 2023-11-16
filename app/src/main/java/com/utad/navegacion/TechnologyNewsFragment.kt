package com.utad.navegacion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.utad.navegacion.databinding.FragmentTechnologyNewsBinding
import com.utad.navegacion.databinding.FragmentWelcomeBinding

class TechnologyNewsFragment : Fragment() {

    private lateinit var _binding:  FragmentTechnologyNewsBinding
    private val binding: FragmentTechnologyNewsBinding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        _binding = FragmentTechnologyNewsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Toast.makeText(requireContext(), "Tecnologia", Toast.LENGTH_SHORT).show()
    }



    }