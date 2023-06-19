package com.example.musafir

import android.media.Image
import java.util.Objects

data class List_State(
    val state_img:Int,
    val state_text:String

)
{
    companion object{
        fun state_info(listState: ArrayList<List_State>):ArrayList<List_State>{
            return listState
        }

    }

}








