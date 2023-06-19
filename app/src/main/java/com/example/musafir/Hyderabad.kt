package com.example.musafir

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.musafir.databinding.ActivityHyderabadBinding

class Hyderabad : AppCompatActivity() {
    private lateinit var binding: ActivityHyderabadBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityHyderabadBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        val chowmhallaPalace = Hyderabad_Monuments(R.drawable.chowmahalla_palace,"Chowmahalla Palace")
        val golcondaFort = Hyderabad_Monuments(R.drawable.golconda_fort,"Golconda Fort")
        val falakNuma = Hyderabad_Monuments(R.drawable.falaknuma_palace,"Falaknuma Palace")

        var ls = arrayListOf<Hyderabad_Monuments>(
            chowmhallaPalace,
            golcondaFort,
            falakNuma
        )

        val obj = Hyderabad_Monuments.hyderabad_info(ls)
        binding.rvHyderabadMonumentImg.layoutManager = LinearLayoutManager(this)
        val hyderabad_info = obj
        val hyderabadAdapter = HyderabadAdapter(hyderabad_info)
        binding?.rvHyderabadMonumentImg?.adapter = hyderabadAdapter

        binding.paymentbtn.setOnClickListener{
            val intent = Intent(this,Payment_form::class.java)
            startActivity(intent)
        }




    }
}