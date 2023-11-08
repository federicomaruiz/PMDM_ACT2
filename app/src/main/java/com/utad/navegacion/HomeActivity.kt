package com.utad.navegacion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.utad.navegacion.databinding.ActivityHomeBinding
import com.utad.navegacion.databinding.ActivityMainBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityHomeBinding
    private val binding: ActivityHomeBinding get() = _binding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        recoverData()

    }

    private fun recoverData() {
        val name = intent.getStringExtra("name")
        val category = intent.getStringExtra("category")
    }
}