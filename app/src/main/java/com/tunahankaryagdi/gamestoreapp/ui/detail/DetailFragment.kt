package com.tunahankaryagdi.gamestoreapp.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.tunahankaryagdi.gamestoreapp.R
import com.tunahankaryagdi.gamestoreapp.databinding.FragmentDetailBinding
import com.tunahankaryagdi.gamestoreapp.databinding.FragmentHomeBinding
import com.tunahankaryagdi.gamestoreapp.ui.detail.adapter.DetailImageAdapter
import com.tunahankaryagdi.gamestoreapp.ui.home.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {

    private val viewModel: DetailViewModel by activityViewModels()
    private lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            var id = DetailFragmentArgs.fromBundle(it).id
            viewModel.getDetailById(id).also {
                observeData()
            }

        }

    }

    private fun observeData() {

        viewModel.loading.observe(viewLifecycleOwner, Observer { isLoading ->
            if (isLoading) {
                binding.pbDetail.visibility = View.VISIBLE
            }
        })

        viewModel.gameDetail.observe(viewLifecycleOwner, Observer { detailGame ->
            detailGame?.let { detailGame ->
                binding.pbDetail.visibility = View.GONE
                binding.detailGame = detailGame
                binding.rvImageList.adapter = DetailImageAdapter(detailGame.screenshots)

            }
        })

    }

}