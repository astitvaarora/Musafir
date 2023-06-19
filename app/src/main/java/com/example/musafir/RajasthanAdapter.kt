package com.example.musafir

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.musafir.databinding.PuneMonumentsBinding
import com.example.musafir.databinding.RajasthanMonumentsBinding

class RajasthanAdapter(
    val Rajasthan_monuments_list : ArrayList<Rajasthan_Monuments>
):RecyclerView.Adapter<RajasthanAdapter.RajasthanViewHolder>() {

    private var onClickListener: RajasthanAdapter.OnClickListener? = null
    inner class RajasthanViewHolder(val binding: RajasthanMonumentsBinding): RecyclerView.ViewHolder(binding.root){
        val img = binding.rajasthanMonumentImg
        val text = binding.rajasthanMonumentText

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RajasthanViewHolder {
        val binding = RajasthanMonumentsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return RajasthanViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return Rajasthan_monuments_list.size
    }

    override fun onBindViewHolder(holder: RajasthanViewHolder, position: Int) {
        val id = Rajasthan_monuments_list[position]
        holder.binding.rajasthanMonumentImg.setBackgroundDrawable(holder.binding.root.context.getResources().getDrawable(id.rajasthan_monument_img))
        holder.binding.rajasthanMonumentText.text = id.rajasthan_monument_text

    }


    fun setOnClickListener(onClickListener: RajasthanAdapter.OnClickListener) {
        this.onClickListener = onClickListener
    }
    interface OnClickListener {
        fun onClick(position: Int, model: Int)
    }



}