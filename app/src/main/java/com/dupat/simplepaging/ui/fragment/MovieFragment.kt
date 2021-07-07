package com.dupat.simplepaging.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.dupat.simplepaging.R
import com.dupat.simplepaging.databinding.FragmentMovieBinding
import com.dupat.simplepaging.ui.adapter.MoviePagingAdapter
import com.dupat.simplepaging.ui.viewmodel.MovieViewModel

class MovieFragment : Fragment() {

    private lateinit var binding: FragmentMovieBinding
    private val viewModel: MovieViewModel by activityViewModels()
    private val movieAdapter = MoviePagingAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        viewModel.movies.observe(requireActivity(), Observer {
            movieAdapter.submitData(lifecycle, it)
        })
    }

    private fun setupRecyclerView() {
        binding.rvMovie.apply {
            adapter = movieAdapter
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }
    }

}