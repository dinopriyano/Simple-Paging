package com.dupat.simplepaging.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.dupat.simplepaging.R
import com.dupat.simplepaging.databinding.ItemMovieListBinding
import com.dupat.simplepaging.ui.Utils.Constant
import com.dupat.simplepaging.ui.Utils.getBackground
import com.dupat.simplepaging.ui.adapter.listener.MovieAdapterListener
import com.dupat.simplepaging.ui.model.ResultModel
import java.text.SimpleDateFormat
import java.util.*

class MoviePagingAdapter(private val movieAdapterListener: MovieAdapterListener): PagingDataAdapter<ResultModel, MoviePagingAdapter.ViewHolder>(DIFF_UTIL) {

    override fun onBindViewHolder(holder: MoviePagingAdapter.ViewHolder, position: Int) {
        holder.bind(getItem(position)!!, position, movieAdapterListener)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MoviePagingAdapter.ViewHolder {
        val binding: ItemMovieListBinding = ItemMovieListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    companion object{
        val DIFF_UTIL = object : DiffUtil.ItemCallback<ResultModel>(){
            override fun areItemsTheSame(oldItem: ResultModel, newItem: ResultModel): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: ResultModel, newItem: ResultModel): Boolean {
                return oldItem == newItem
            }

        }
    }

    inner class ViewHolder(val binding: ItemMovieListBinding): RecyclerView.ViewHolder(binding.root), View.OnClickListener {

        private lateinit var movieAdapterListener: MovieAdapterListener
        private lateinit var model: ResultModel
        private var pos: Int = 0

        @SuppressLint("UseCompatLoadingForDrawables")
        fun bind(model: ResultModel, position: Int, movieAdapterListener: MovieAdapterListener){

            this.movieAdapterListener = movieAdapterListener
            this.model = model
            this.pos = position

            with(binding){

                val toDateFormat = SimpleDateFormat("yyyy-MM-dd")
                val toStringFormat = SimpleDateFormat("dd MMM yyyy")
                cvContainer.setOnClickListener(this@ViewHolder)

                container.background = itemView.context.getDrawable(position.getBackground())

                txtTitle.text = model.title
                txtRating.text = model.vote_average.toString()
                txtDate.text = toStringFormat.format(if(model.release_date.isEmpty()) Date() else toDateFormat.parse(model.release_date))
                Glide.with(itemView.context).load(Constant.IMAGE_URL+model.poster_path).apply(RequestOptions.bitmapTransform(RoundedCorners(15))).into(ivMovie)
            }
        }

        override fun onClick(v: View?) {
            when(v?.id!!){
                R.id.cvContainer -> {
                    movieAdapterListener.OnMovieClick(model, pos)
                }
            }
        }

    }

}