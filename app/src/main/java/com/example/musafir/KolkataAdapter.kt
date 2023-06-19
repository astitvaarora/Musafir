package com.example.musafir

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.musafir.databinding.DelhiMonumentsBinding
import com.example.musafir.databinding.KolkataMonumentsBinding

class KolkataAdapter(
    val Kolkata_monument_list : ArrayList<Kolkata_Monuments>
):RecyclerView.Adapter<KolkataAdapter.KolkataViewHolder>(){
    private var onClickListener: KolkataAdapter.OnClickListener? = null

    inner class KolkataViewHolder(val binding: KolkataMonumentsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val img = binding.kolkataMonumentImg
        val text = binding.kolkataMonumentText

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KolkataViewHolder {
        val binding = KolkataMonumentsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return KolkataViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return Kolkata_monument_list.size
    }

    override fun onBindViewHolder(holder: KolkataViewHolder, position: Int) {
        val id = Kolkata_monument_list[position]
        holder.binding.kolkataMonumentImg.setBackgroundDrawable(
            holder.binding.root.context.getResources().getDrawable(id.kolkata_monument_img)
        )
        holder.binding.kolkataMonumentText.text = id.kolkata_monument_text

    }

    fun setOnClickListener(onClickListener: KolkataAdapter.OnClickListener) {
        this.onClickListener = onClickListener
    }

    interface OnClickListener {
        fun onClick(position: Int, model: Int)
    }
}