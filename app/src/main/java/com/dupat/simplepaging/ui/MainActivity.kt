package com.dupat.simplepaging.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.dupat.simplepaging.R
import com.dupat.simplepaging.databinding.ActivityMainBinding
import com.dupat.simplepaging.ui.adapter.MoviePagingAdapter
import com.dupat.simplepaging.ui.viewmodel.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MovieViewModel by viewModels()
    private val movieAdapter = MoviePagingAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
        viewModel.movies.observe(this, Observer {
            movieAdapter.submitData(lifecycle, it)
        })
    }

    private fun setupRecyclerView() {
        binding.rvMovie.apply {
            adapter = movieAdapter
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
        }
    }
}