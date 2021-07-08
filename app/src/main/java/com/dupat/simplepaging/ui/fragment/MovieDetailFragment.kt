package com.dupat.simplepaging.ui.fragment

import android.graphics.PorterDuff
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.bumptech.glide.Glide
import com.dupat.simplepaging.R
import com.dupat.simplepaging.databinding.FragmentMovieDetailBinding
import com.dupat.simplepaging.ui.Utils.*
import com.dupat.simplepaging.ui.adapter.CompanyAdapter
import com.dupat.simplepaging.ui.viewmodel.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MovieDetailFragment : Fragment() {

    private lateinit var binding: FragmentMovieDetailBinding
    private lateinit var loadingDialog: LoadingDialog
    private lateinit var companyAdapter: CompanyAdapter
    private var movieID = 0
    private var position = -1
    private val viewModel: MovieViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMovieDetailBinding.inflate(inflater,container, false )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        movieID = MovieDetailFragmentArgs.fromBundle(requireArguments()).movieId
        position = MovieDetailFragmentArgs.fromBundle(requireArguments()).position

        viewModel.setBackground(position.getBackground())

        loadingDialog = LoadingDialog(requireActivity())

        handleUIState()
        observeData()
        viewModel.movieDetail(movieID)
    }

    private fun observeData() {
        viewModel.getMovie().observe(requireActivity()){
            binding.apply {
                Glide.with(requireContext()).load(Constant.IMAGE_URL+it.poster_path).into(ivMovie)
                Glide.with(requireContext()).load(Constant.IMAGE_URL+it.backdrop_path).error(R.drawable.default_backdrop).into(ivBackdrop)
                txtTitle.text = it.title
                txtFrom.text = "from ${if(it.production_countries.isEmpty()) "United States" else it.production_countries[0].name}"
                txtRating.text = it.vote_average.toString()
                txtOverview.text = it.overview

                companyAdapter = CompanyAdapter(it.production_companies)
                rvCompany.apply {
                    layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
                    adapter = companyAdapter
                }

            }
        }
    }

    private fun handleUIState() {
        viewModel.getState().observer(requireActivity()){
            when(it){
                is ViewState.isLoading -> {
                    if(it.state){
                        if(loadingDialog.isDialogShowing()){
                            loadingDialog.dismisDialog()
                        }
                        loadingDialog.startLoadingDialog()
                    }
                    else{
                        loadingDialog.dismisDialog()
                    }
                }
                is ViewState.isError -> {
                    binding.container.snackbar(it.err?:"Some error")
                }
            }
        }
    }


}