package com.utad.navegacion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.utad.navegacion.databinding.ActivityHomeBinding
import kotlin.system.exitProcess

class HomeActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityHomeBinding
    private val binding: ActivityHomeBinding get() = _binding

    lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var checkSelected : String = recoverData()
        setBottomNavigation(checkSelected)

    }



    private fun setBottomNavigation(checkSelected: String) {
      val navHostFragment: NavHostFragment =
          supportFragmentManager.findFragmentById(binding.nhfView.id) as NavHostFragment
      navController = navHostFragment.findNavController()


        if (navHostFragment != null) {
            binding.bnvNews.setupWithNavController(navController)
        }


        val startDestination = when (checkSelected) {
            "Muéstrame todas" -> R.id.generalNewsFragment
            "Deportes" -> R.id.sportNewsFragment
            "Tecnología" -> R.id.technologyNewsFragment
            else -> exitProcess(0)
        }

        navController.navigate(startDestination)



    }

    private fun recoverData(): String {
        val name = intent.getStringExtra("name")
        val category = intent.getStringExtra("category")

        return category.toString()
    }


    }