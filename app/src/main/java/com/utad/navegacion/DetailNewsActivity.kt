package com.utad.navegacion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.utad.navegacion.data.generalNews
import com.utad.navegacion.data.getAllNews
import com.utad.navegacion.data.getSports
import com.utad.navegacion.data.getTech
import com.utad.navegacion.databinding.ActivityDetailBinding

class DetailNewsActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityDetailBinding
    private val binding: ActivityDetailBinding get() = _binding

    private lateinit var idTitle: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        idTitle = recoverData()
        setFragment(idTitle)
    }

    private fun setFragment(idTitle: String) {
        val list = getTech() + getSports() + getAllNews()
        for (news in list) {
            if (news.title == idTitle) {
                binding.tvDetailTitle.text = news.title
                Glide.with(binding.root)
                    .load(news.image)
                    .into(binding.imageDetail)
                binding.tvDetailAuthor.text = news.author
                binding.tvDetailDescription.text = news.description

                break // Romper el bucle después de encontrar la coincidencia
            }
        }

    }

    private fun recoverData(): String {
        val id = intent.getStringExtra("title")
        return id.toString()
    }

}