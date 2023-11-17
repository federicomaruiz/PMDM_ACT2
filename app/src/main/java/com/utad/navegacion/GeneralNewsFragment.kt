package com.utad.navegacion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import com.utad.navegacion.data.getAllNews
import com.utad.navegacion.data.getSports
import com.utad.navegacion.data.getTech
import com.utad.navegacion.databinding.FragmentGeneralNewsBinding
import com.utad.navegacion.recyclerView.New
import com.utad.navegacion.recyclerView.RecyclerViewAdapter

class GeneralNewsFragment : Fragment() {

    private lateinit var _binding: FragmentGeneralNewsBinding

    private val binding : FragmentGeneralNewsBinding get() = _binding

    private lateinit var adapter : RecyclerViewAdapter

    private lateinit var btnWell : ExtendedFloatingActionButton


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGeneralNewsBinding.inflate(inflater,container,false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvGeneral.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)
        val list = getAllNews()
        loadRecyclerView(list)
        listenBtnWell()
    }

    private fun loadRecyclerView(list: List<New>) {
        adapter = RecyclerViewAdapter(list)
        binding.rvGeneral.adapter = adapter
        btnWell = binding.btnWell
    }

    private fun listenBtnWell() {
        btnWell.setOnClickListener {
            val list = getAllNews() + getSports() + getTech()
            loadRecyclerView(list)
        }
    }


}