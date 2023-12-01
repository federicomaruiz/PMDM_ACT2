package com.utad.navegacion

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.utad.navegacion.data.getTech
import com.utad.navegacion.recyclerView.RecyclerViewAdapter
import com.utad.navegacion.databinding.FragmentTechnologyNewsBinding


class TechnologyNewsFragment : Fragment() {

    private lateinit var _binding: FragmentTechnologyNewsBinding
    private val binding: FragmentTechnologyNewsBinding get() = _binding

    private lateinit var adapter: RecyclerViewAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        _binding = FragmentTechnologyNewsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvTecnologia.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        val list = getTech()
        adapter = RecyclerViewAdapter(list) { id -> navigateToDetail(id) }
        binding.rvTecnologia.adapter = adapter

    }

    private fun navigateToDetail(id: String) {
        val intent = Intent(requireContext(), DetailNewsActivity::class.java)
        intent.putExtra("title", id)
        startActivity(intent)
    }

}


