package com.example.musafir

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.musafir.databinding.AgraMonumentsBinding



class AgraAdapter (
    val Agra_monuments_list: ArrayList<Agra_Monuments>
    ):RecyclerView.Adapter<AgraAdapter.AgraViewHolder>(){

    private var onClickListener : AgraAdapter.OnClickListener? = null

    inner class AgraViewHolder(val binding: AgraMonumentsBinding):RecyclerView.ViewHolder(binding.root){
        val img = binding.agraMonumentImg
        val text = binding.agraMonumentText
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):AgraAdapter.AgraViewHolder {
        val binding = AgraMonumentsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return AgraViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AgraAdapter.AgraViewHolder, position: Int) {
        val id = Agra_monuments_list[position]
        holder.binding.agraMonumentImg.setBackgroundDrawable(holder.binding.root.context.getResources().getDrawable(id.agra_monument_img))
        holder.binding.agraMonumentText.text = id.agra_monument_text

    }

    override fun getItemCount(): Int {
        return Agra_monuments_list.size
    }

    fun setOnClickListener(onClickListener: AgraAdapter.OnClickListener) {
        this.onClickListener = onClickListener
    }
    interface OnClickListener {
        fun onClick(position: Int, model: Int)
    }




}