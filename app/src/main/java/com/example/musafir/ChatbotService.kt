package com.example.musafir

import android.telecom.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ChatbotService {
    @POST("chatbot")
    suspend fun sendMessage(@Body message: String): ChatResponse
}