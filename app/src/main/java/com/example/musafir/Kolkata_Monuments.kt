package com.example.musafir

data class Kolkata_Monuments(
    val kolkata_monument_img : Int,
    val kolkata_monument_text : String
) {

    companion object{
        fun kolkata_info(listKolkata: ArrayList<Kolkata_Monuments>):ArrayList<Kolkata_Monuments>{
            return listKolkata
        }
    }
}