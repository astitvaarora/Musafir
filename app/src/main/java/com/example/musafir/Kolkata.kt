package com.example.musafir

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.musafir.databinding.ActivityKolkataBinding

class Kolkata : AppCompatActivity() {
    private lateinit var binding : ActivityKolkataBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityKolkataBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val indianMuseum = Kolkata_Monuments(R.drawable.indian_museum,"Indian Museum")
        val victoriaPalace = Kolkata_Monuments(R.drawable.victoria_palace,"Victoria Palace")
        val jarosankoThakur = Kolkata_Monuments(R.drawable.jorasanko_thakurbari,"Jarosanko Thakurbari")

        var ls = arrayListOf<Kolkata_Monuments>(
            indianMuseum,
            victoriaPalace,
            jarosankoThakur
        )

        val obj = Kolkata_Monuments.kolkata_info(ls)
        binding.rvKolkataMonumentImg.layoutManager = LinearLayoutManager(this)
        val kolkata_info = obj
        val kolkataAdapter = KolkataAdapter(kolkata_info)
        binding?.rvKolkataMonumentImg?.adapter = kolkataAdapter

        binding.paymentbtn.setOnClickListener{
            val intent = Intent(this,Payment_form::class.java)
            startActivity(intent)
        }


    }
}