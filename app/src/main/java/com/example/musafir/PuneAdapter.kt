package com.example.musafir

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.musafir.databinding.PuneMonumentsBinding

class PuneAdapter(
    val Pune_monuments_list : ArrayList<Pune_Monuments>
): RecyclerView.Adapter<PuneAdapter.PuneViewHolder>(){

    private var onClickListener: PuneAdapter.OnClickListener? = null

    inner class PuneViewHolder(val binding: PuneMonumentsBinding): RecyclerView.ViewHolder(binding.root){
        val img = binding.puneMonumentImg
        val text = binding.puneMonumentText

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):PuneViewHolder {
        val binding = PuneMonumentsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PuneViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return Pune_monuments_list.size
    }

    override fun onBindViewHolder(holder: PuneViewHolder, position: Int) {
        val id = Pune_monuments_list[position]
        holder.binding.puneMonumentImg.setBackgroundDrawable(holder.binding.root.context.getResources().getDrawable(id.pune_monument_img))
        holder.binding.puneMonumentText.text = id.pune_monument_text

    }

    fun setOnClickListener(onClickListener: PuneAdapter.OnClickListener) {
        this.onClickListener = onClickListener
    }
    interface OnClickListener {
        fun onClick(position: Int, model: Int)
    }

}