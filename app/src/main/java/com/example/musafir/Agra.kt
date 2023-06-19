package com.example.musafir

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.musafir.databinding.ActivityAgraBinding
import com.example.musafir.databinding.ActivityPuneBinding

class Agra : AppCompatActivity() {
    private lateinit var binding: ActivityAgraBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityAgraBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val tajMahal = Agra_Monuments(R.drawable.taj_mahal,"Taj Mahal")
        val fatehpurSikri = Agra_Monuments(R.drawable.fatehpur_sikri,"Fatehpur Sikri")
        val agraFort = Agra_Monuments(R.drawable.agra_fort,"Agra Fort")

        var ls = arrayListOf<Agra_Monuments>(
            tajMahal,
            fatehpurSikri,
            agraFort
        )

        val obj = Agra_Monuments.agra_info(ls)
        binding.rvAgraMonumentImg.layoutManager = LinearLayoutManager(this)
        val agra_info = obj
        val agraAdapter = AgraAdapter(agra_info)
        binding?.rvAgraMonumentImg?.adapter = agraAdapter
        binding.paymentbtn.setOnClickListener {
            val intent = Intent(this,Payment_form::class.java)
            startActivity(intent)
        }

    }

}