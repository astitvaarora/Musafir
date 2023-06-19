package com.example.musafir

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.musafir.databinding.ActivityDelhiBinding


private lateinit var binding:ActivityDelhiBinding
class Delhi_new : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDelhiBinding.inflate(layoutInflater)
        val view = binding.root
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






    }
}