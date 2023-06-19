package com.example.musafir

data class Delhi_Monuments(
    val delhi_monument_img:Int,
    val delhi_monument_text:String
) {

    companion object{
        fun delhi_info(listDelhi: ArrayList<Delhi_Monuments>):ArrayList<Delhi_Monuments>{
            return listDelhi
        }

    }
}