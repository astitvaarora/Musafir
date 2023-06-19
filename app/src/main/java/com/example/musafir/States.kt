package com.example.musafir

import android.content.Intent
import android.net.NetworkInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.musafir.databinding.ActivityStatesBinding
import java.lang.Thread.State

class States : AppCompatActivity() {
    private lateinit var binding: ActivityStatesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStatesBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        val delhi = List_State(R.drawable.delhi_thumb,"Delhi")
        val pune=List_State(R.drawable.pune,"Pune")
        val agra=List_State(R.drawable.agra,"Agra")
        val rajasthan=List_State(R.drawable.rajisthan,"Rajasthan")
        val hyderabad=List_State(R.drawable.hyderabad,"Hyderabad")
        val kolkata=List_State(R.drawable.kolkata,"Kolkata")


        var ls =  arrayListOf<List_State>(
            delhi,
            pune,
            agra,
            rajasthan,
            hyderabad,
            kolkata
            )


        val obj = List_State.state_info(ls)
        binding.rvStateImg.layoutManager = LinearLayoutManager(this)
        val stateinfo = obj
        val statesAdapter = StatesAdapter(stateinfo)
        binding?.rvStateImg?.adapter = statesAdapter

        statesAdapter.setOnClickListener(
            object:StatesAdapter.OnClickListener{
                override fun onClick(position: Int, model: Int) {
                    when(position){
                        0 -> {
                            val intent = Intent(this@States,Delhi::class.java)
                            startActivity(intent)
                        }
                        1 -> {
                            val intent = Intent(this@States,Pune::class.java)
                            startActivity(intent)
                        }
                        2 ->{
                            val intent = Intent(this@States,Agra::class.java)
                            startActivity(intent)
                        }
                        3 ->{
                            val intent = Intent(this@States,Rajasthan::class.java)
                            startActivity(intent)
                        }
                        4 ->{
                            val intent = Intent(this@States,Hyderabad::class.java)
                            startActivity(intent)
                        }
                        5 ->{
                            val intent = Intent(this@States,Kolkata::class.java)
                            startActivity(intent)
                        }
                    }


                }
            })
    }
}