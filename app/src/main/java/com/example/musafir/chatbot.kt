package com.example.musafir

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.lifecycle.lifecycleScope
import com.example.musafir.databinding.ActivityChatbotBinding
import com.example.musafir.databinding.ActivityMainBinding
import kotlinx.coroutines.launch
import okhttp3.Call
import okhttp3.Callback
import okhttp3.FormBody
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import org.json.JSONObject
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

class chatbot : AppCompatActivity() {
    private lateinit var binding: ActivityChatbotBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChatbotBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        var conv : Button = binding.button
        val url = "http://192.168.178.106:5000" // Replace with your server IP address
        val instance: ChatbotService by lazy {
            val retrofit = Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            retrofit.create(ChatbotService::class.java)
        }
        conv.setOnClickListener {
            try {
                lifecycleScope.launch{
                    val response = instance.sendMessage(binding.editText.text.toString())
                    val txt : TextView =  binding.textView
                    txt.setText(response.response)
                    Log.d("tag",response.response)
                }
            }catch (e:Exception){
                Log.d("tag",e.toString())
            }

        }
    }
}