package com.example.musafir

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.musafir.databinding.ActivityDelhiBinding

class Delhi : AppCompatActivity() {
    private lateinit var binding : ActivityDelhiBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityDelhiBinding.inflate(layoutInflater)
        val view = binding.root
        super.onCreate(savedInstanceState)
        setContentView(view)

        val humayunTomb = Delhi_Monuments(R.drawable.humayun_tomb,"Humayun's Tomb")
        val qutubMinar = Delhi_Monuments(R.drawable.qutub_minar,"Qutub Minar")
        val redFort = Delhi_Monuments(R.drawable.red_fort,"Red Fort")

        var ls = arrayListOf<Delhi_Monuments>(
            humayunTomb,
            qutubMinar,
            redFort
        )

        val obj = Delhi_Monuments.delhi_info(ls)

        binding.rvDelhiMonumentImg.layoutManager = LinearLayoutManager(this)
        val delhi_info = obj
        val delhiAdapter = DelhiAdapter(delhi_info)
        binding?.rvDelhiMonumentImg?.adapter = delhiAdapter

        binding.paymentbtn.setOnClickListener{
            val intent = Intent(this,Payment_form::class.java)
            startActivity(intent)
        }


    }
}