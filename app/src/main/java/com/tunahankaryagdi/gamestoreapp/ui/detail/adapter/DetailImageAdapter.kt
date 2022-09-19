package com.tunahankaryagdi.gamestoreapp.ui.detail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tunahankaryagdi.gamestoreapp.data.model.Screenshot
import com.tunahankaryagdi.gamestoreapp.databinding.DetailImageItemBinding

class DetailImageAdapter(var imageList: List<Screenshot>) :
    RecyclerView.Adapter<DetailImageAdapter.DetailImageViewHolder>() {

    class DetailImageViewHolder(private val binding: DetailImageItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

            fun bind(screenshot :Screenshot){
                binding.screenshot = screenshot
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailImageViewHolder {
        val view =
            DetailImageItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DetailImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: DetailImageViewHolder, position: Int) {
        holder.bind(imageList[position])
    }

    override fun getItemCount(): Int {
        return imageList.size
    }


}