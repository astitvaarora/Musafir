package com.example.musafir

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.musafir.databinding.ActivityRajasthanBinding
import com.example.musafir.databinding.RajasthanMonumentsBinding

class Rajasthan : AppCompatActivity() {
    private lateinit var binding: ActivityRajasthanBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityRajasthanBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val jantarMantar = Rajasthan_Monuments(R.drawable.jantar_mantar,"Jantar_Mantar")
        val amberFort = Rajasthan_Monuments(R.drawable.amber_fort,"Amber Fort")
        val hawaMahal = Rajasthan_Monuments(R.drawable.hawa_mahal,"Hawa Mahal")

        var ls = arrayListOf<Rajasthan_Monuments>(
            jantarMantar,
            amberFort,
            hawaMahal
        )

        val obj = Rajasthan_Monuments.rajasthan_info(ls)
        binding.rvRajasthanMonumentImg.layoutManager = LinearLayoutManager(this)
        val rajasthan_info = obj
        val rajasthanAdapter = RajasthanAdapter(rajasthan_info)
        binding?.rvRajasthanMonumentImg?.adapter = rajasthanAdapter

        binding.paymentbtn.setOnClickListener {
            val intent = Intent(this,Payment_form::class.java)
            startActivity(intent)
        }










    }
}