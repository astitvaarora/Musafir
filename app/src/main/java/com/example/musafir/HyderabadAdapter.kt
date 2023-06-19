package com.example.musafir

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.musafir.databinding.AgraMonumentsBinding
import com.example.musafir.databinding.HyderabadMonumentsBinding

class HyderabadAdapter(
    val Hyderabad_monuments_list: ArrayList<Hyderabad_Monuments>
): RecyclerView.Adapter<HyderabadAdapter.HyderabadViewHolder>() {

    private var onClickListener : HyderabadAdapter.OnClickListener? = null

    inner class HyderabadViewHolder(val binding: HyderabadMonumentsBinding):RecyclerView.ViewHolder(binding.root){
        val img = binding.hyderabadMonumentImg
        val text = binding.hyerabadMonumentText
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):HyderabadAdapter.HyderabadViewHolder {
        val binding = HyderabadMonumentsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return HyderabadViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HyderabadViewHolder, position: Int) {
        val id =  Hyderabad_monuments_list[position]
        holder.binding.hyderabadMonumentImg.setBackgroundDrawable(holder.binding.root.context.getResources().getDrawable(id.hyderabad_monument_img))
        holder.binding.hyerabadMonumentText.text = id.hyderabad_monument_text
    }

    override fun getItemCount(): Int {
        return Hyderabad_monuments_list.size
    }

    fun setOnClickListener(onClickListener: HyderabadAdapter.OnClickListener) {
        this.onClickListener = onClickListener
    }
    interface OnClickListener {
        fun onClick(position: Int, model: Int)
    }




}