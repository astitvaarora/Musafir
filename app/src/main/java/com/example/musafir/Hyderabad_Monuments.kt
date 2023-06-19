package com.example.musafir

data class Hyderabad_Monuments(
    val hyderabad_monument_img:Int,
    val hyderabad_monument_text:String
) {

    companion object{
        fun hyderabad_info(listHyerabad: ArrayList<Hyderabad_Monuments>):ArrayList<Hyderabad_Monuments>{
            return listHyerabad
        }

    }
}