package com.example.musafir

data class Agra_Monuments(
    val agra_monument_img:Int,
    val agra_monument_text:String
) {

    companion object{
        fun agra_info(listAgra: ArrayList<Agra_Monuments>):ArrayList<Agra_Monuments>{
            return listAgra
        }

    }
}