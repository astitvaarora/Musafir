package com.example.musafir

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.musafir.databinding.ActivityDelhiBinding
import com.example.musafir.databinding.DelhiMonumentsBinding

class DelhiAdapter(
    val Delhi_monuments_list : ArrayList<Delhi_Monuments>
):RecyclerView.Adapter<DelhiAdapter.DelhiViewHolder>() {

    private var onClickListener: DelhiAdapter.OnClickListener? = null

    inner class DelhiViewHolder(val binding: DelhiMonumentsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val img = binding.delhiMonumentImg
        val text = binding.delhiMonumentText

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DelhiViewHolder {
        val binding = DelhiMonumentsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DelhiViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return Delhi_monuments_list.size
    }

    override fun onBindViewHolder(holder: DelhiViewHolder, position: Int) {
        val id = Delhi_monuments_list[position]
        holder.binding.delhiMonumentImg.setBackgroundDrawable(
            holder.binding.root.context.getResources().getDrawable(id.delhi_monument_img)
        )
        holder.binding.delhiMonumentText.text = id.delhi_monument_text
    }

    fun setOnClickListener(onClickListener: DelhiAdapter.OnClickListener) {
        this.onClickListener = onClickListener
    }

    interface OnClickListener {
        fun onClick(position: Int, model: Int)
    }

}