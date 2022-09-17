package com.tunahankaryagdi.gamestoreapp.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tunahankaryagdi.gamestoreapp.data.model.Game
import com.tunahankaryagdi.gamestoreapp.databinding.HomeListItemBinding


class HomeAdapter(private var listener : ItemClickListener) : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    var gameList: List<Game> = emptyList()

    class HomeViewHolder(private val binding: HomeListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {


        fun bind(game: Game ,listener: ItemClickListener) {
            binding.game = game
            binding.listener = listener
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        var binding = HomeListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        var game = gameList[position]
        holder.bind(game ,listener)

    }

    override fun getItemCount(): Int {

        if (gameList.isEmpty()) {
            return 0
        } else {
            return gameList.size
        }

    }

    fun setList(list: List<Game>) {
        gameList = list
        notifyDataSetChanged()
    }

}
interface ItemClickListener{
    fun onItemClick(game: Game)
}