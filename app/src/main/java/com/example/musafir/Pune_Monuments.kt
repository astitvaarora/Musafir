package com.example.musafir

data class Pune_Monuments(
    val pune_monument_img:Int,
    val pune_monument_text:String
) {

    companion object{
        fun pune_info(listPune: ArrayList<Pune_Monuments>):ArrayList<Pune_Monuments>{
            return listPune
        }

    }
}