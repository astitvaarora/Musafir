package com.example.musafir

import android.media.Image
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.musafir.databinding.ActivityStatesBinding
import com.example.musafir.databinding.ListStateImagesBinding


class StatesAdapter (
    val states : ArrayList<List_State>
):RecyclerView.Adapter<StatesAdapter.StateViewHolder>(){

    private var onClickListener: OnClickListener? = null

    inner class StateViewHolder(val binding: ListStateImagesBinding):RecyclerView.ViewHolder(binding.root){
        var img = binding.stateImg
        var btn = binding.StateExploreBtn
        var txt = binding.stateName

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StateViewHolder {
        val binding = ListStateImagesBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return StateViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StateViewHolder, position: Int) {
        val id = states[position]
        holder.binding.stateImg.setBackgroundDrawable(holder.binding.root.context.getResources().getDrawable(id.state_img))
        holder.binding.stateName.text = id.state_text
        holder.binding.StateExploreBtn.setOnClickListener{
            if(onClickListener != null){
//                if(id.state_text=="Delhi")
//                    onClickListener!!.onClick(position,id.state_img)
//                if(id.state_text=="Pune")
//                    onClickListener!!.onClick(position,id.state_img)
//                if(id.)
                when(id.state_text){
                    "Delhi"-> onClickListener!!.onClick(position,id.state_img)
                    "Pune"-> onClickListener!!.onClick(position,id.state_img)
                    "Agra"-> onClickListener!!.onClick(position,id.state_img)
                    "Rajasthan"-> onClickListener!!.onClick(position,id.state_img)
                    "Hyderabad"-> onClickListener!!.onClick(position,id.state_img)
                    "Kolkata"-> onClickListener!!.onClick(position,id.state_img)
                }
            }
        }

    }
    fun setOnClickListener(onClickListener: OnClickListener) {
        this.onClickListener = onClickListener
    }
    interface OnClickListener {
        fun onClick(position: Int, model: Int)
    }

    override fun getItemCount(): Int {
        return states.size
    }
}