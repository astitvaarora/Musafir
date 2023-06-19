package com.example.musafir

data class Rajasthan_Monuments(
    val rajasthan_monument_img:Int,
    val rajasthan_monument_text:String
) {

    companion object{
        fun rajasthan_info(listRajasthan: ArrayList<Rajasthan_Monuments>):ArrayList<Rajasthan_Monuments>{
            return listRajasthan
        }

    }
}