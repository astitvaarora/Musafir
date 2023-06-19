package com.example.musafir

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.musafir.databinding.ActivitySelectStateGridBinding
import pl.droidsonroids.gif.GifImageView

class select_state_grid : AppCompatActivity() {
    private lateinit var binding: ActivitySelectStateGridBinding
    lateinit var dl_clk : GifImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySelectStateGridBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        binding.Delhi.setOnClickListener {
            val intent = Intent(this,Delhi::class.java)
            startActivity(intent)
        }
        binding.pune.setOnClickListener {
            val intent = Intent(this,Pune::class.java)
            startActivity(intent)
        }
        binding.agra.setOnClickListener {
            val intent = Intent(this,Agra::class.java)
            startActivity(intent)
        }
        binding.rajasthan.setOnClickListener {
            val intent = Intent(this,Rajasthan::class.java)
            startActivity(intent)
        }
        binding.hyderabad.setOnClickListener {
            val intent = Intent(this,Hyderabad::class.java)
            startActivity(intent)
        }
        binding.kolkata.setOnClickListener {
            val intent = Intent(this,Kolkata::class.java)
            startActivity(intent)
        }
        binding.chatIcon.setOnClickListener {
            val intent = Intent(this@select_state_grid,chatbot::class.java)
            startActivity(intent)
        }


    }
}