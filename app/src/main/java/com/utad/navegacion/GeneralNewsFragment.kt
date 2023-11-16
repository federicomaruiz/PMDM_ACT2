package com.utad.navegacion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.utad.navegacion.databinding.FragmentGeneralNewsBinding

class GeneralNewsFragment : Fragment() {

    private lateinit var _binding: FragmentGeneralNewsBinding

    private val binding : FragmentGeneralNewsBinding get() = _binding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGeneralNewsBinding.inflate(inflater,container,false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Toast.makeText(requireContext(), "general", Toast.LENGTH_SHORT).show()
    }

}