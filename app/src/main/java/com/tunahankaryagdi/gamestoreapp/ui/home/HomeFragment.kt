package com.tunahankaryagdi.gamestoreapp.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.tunahankaryagdi.gamestoreapp.R
import com.tunahankaryagdi.gamestoreapp.data.model.Game
import com.tunahankaryagdi.gamestoreapp.databinding.FragmentHomeBinding
import com.tunahankaryagdi.gamestoreapp.ui.home.adapter.HomeAdapter
import com.tunahankaryagdi.gamestoreapp.ui.home.adapter.ItemClickListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var adapter: HomeAdapter
    private val viewModel: HomeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        observeData()
        binding.homeSwipe.setOnRefreshListener {
            viewModel.getAll()
            binding.homeSwipe.isRefreshing = false
        }
    }


    private fun initViews() {
        adapter = HomeAdapter(object : ItemClickListener {
            override fun onItemClick(game: Game) {

                val action =
                    HomeFragmentDirections.actionHomeFragmentToDetailFragment(game.id.toString())

                Navigation.findNavController(requireView()).navigate(action)
            }

        })
        binding.rvList.adapter = adapter
    }

    private fun observeData() {

        viewModel.loading.observe(viewLifecycleOwner, Observer { isLoading ->
            if (isLoading) {
                binding.pbHome.visibility = View.VISIBLE
                binding.rvList.visibility = View.GONE
            }
        })

        viewModel.gameList.observe(viewLifecycleOwner, Observer { gameList ->
            if (gameList.isNotEmpty()) {
                binding.pbHome.visibility = View.GONE
                adapter.setList(gameList)
                binding.rvList.visibility = View.VISIBLE
            }
        })
    }
}