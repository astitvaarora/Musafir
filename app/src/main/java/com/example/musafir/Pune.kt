package com.example.musafir

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.musafir.databinding.ActivityPuneBinding

class Pune : AppCompatActivity() {
    private lateinit var binding : ActivityPuneBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityPuneBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val agaKhanPalace = Pune_Monuments(R.drawable.aga_khan_palace,"Aga Khan Palace")
        val shaniwarWada = Pune_Monuments(R.drawable.shaniwar_wada,"Shaniwar Wada")
        val rajaDinkerKelkerMuseum = Pune_Monuments(R.drawable.raja_dinkar_kelkar_museum,"Raja Dinker Kelker Museum")

        var ls = arrayListOf<Pune_Monuments>(
            agaKhanPalace,
            shaniwarWada,
            rajaDinkerKelkerMuseum
        )

        val obj = Pune_Monuments.pune_info(ls)
        binding.rvPuneMonumentImg.layoutManager = LinearLayoutManager(this)
        val pune_info = obj
        val puneAdapter = PuneAdapter(pune_info)
        binding?.rvPuneMonumentImg?.adapter = puneAdapter

        binding.paymentbtn.setOnClickListener {
            val intent = Intent(this,Payment_form::class.java)
            startActivity(intent)
        }

    }
}