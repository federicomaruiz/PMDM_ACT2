package com.utad.navegacion

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.utad.navegacion.data.getSports
import com.utad.navegacion.recyclerView.RecyclerViewAdapter
import com.utad.navegacion.databinding.FragmentSportNewsBinding

class SportNewsFragment : Fragment() {

    private lateinit var _binding: FragmentSportNewsBinding

    private val binding : FragmentSportNewsBinding get() = _binding

    private lateinit var adapter : RecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSportNewsBinding.inflate(inflater,container,false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvSports.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)
        val list = getSports()
        adapter = RecyclerViewAdapter(list) {id -> navigateToDetail(id)}
        binding.rvSports.adapter = adapter

    }

    private fun navigateToDetail(id: String) {
        val intent = Intent(requireContext(), DetailNewsActivity::class.java)
        intent.putExtra("title", id)
        startActivity(intent)
    }


}