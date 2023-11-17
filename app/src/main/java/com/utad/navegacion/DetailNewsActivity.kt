package com.utad.navegacion

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.utad.navegacion.data.getAllNews
import com.utad.navegacion.data.getSports
import com.utad.navegacion.data.getTech
import com.utad.navegacion.databinding.ActivityDetailBinding
import com.utad.navegacion.databinding.ActivityHomeBinding

class DetailNewsActivity : AppCompatActivity() {


    private lateinit var _binding: ActivityDetailBinding
    private val binding: ActivityDetailBinding get() = _binding

    private lateinit var title: TextView
    private lateinit var image: ImageView
    private lateinit var author: TextView
    private lateinit var description: TextView

    private lateinit var idTitle : String



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initComponents()
        idTitle = recoverData()
        setFragment(idTitle)
    }

    private fun setFragment(idTitle: String) {
        val list = getTech() + getSports() + getAllNews()

        for (news in list) {
            if (news.title == idTitle) {
                title.text = news.title
                Glide.with(binding.root)
                    .load(news.image)
                    .into(binding.imageDetail)
                author.text = news.author
                description.text = news.description

                break // Romper el bucle después de encontrar la coincidencia
            }
        }

    }

    private fun initComponents() {
        title = binding.tvDetailTitle
        image = binding.imageDetail
        author = binding.tvDetailAuthor
        description = binding.tvDetailDescription
    }

    private fun recoverData(): String {
        val id = intent.getStringExtra("title")
        return id.toString()
    }


}