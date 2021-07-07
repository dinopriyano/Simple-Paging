package com.dupat.simplepaging.ui.adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
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
import com.dupat.simplepaging.ui.model.ResultModel
import java.text.SimpleDateFormat
import java.util.*

class MoviePagingAdapter: PagingDataAdapter<ResultModel, MoviePagingAdapter.ViewHolder>(DIFF_UTIL) {

    override fun onBindViewHolder(holder: MoviePagingAdapter.ViewHolder, position: Int) {
        holder.bind(getItem(position)!!, position)
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

    inner class ViewHolder(val binding: ItemMovieListBinding): RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("UseCompatLoadingForDrawables")
        fun bind(model: ResultModel, position: Int){
            with(binding){

                val toDateFormat = SimpleDateFormat("yyyy-MM-dd")
                val toStringFormat = SimpleDateFormat("dd MMM yyyy")

                container.background = itemView.context.getDrawable(
                    when((position+1) % 6){
                        1 -> R.drawable.gradient_blue
                        2 -> R.drawable.gradient_pink
                        3 -> R.drawable.gradient_orange
                        4 -> R.drawable.gradient_purple
                        5 -> R.drawable.gradient_blue_sea
                        else -> R.drawable.gradient_red_heart
                    }
                )

                txtTitle.text = model.title
                txtRating.text = model.vote_average.toString()
                txtDate.text = toStringFormat.format(if(model.release_date.isEmpty()) Date() else toDateFormat.parse(model.release_date))
                Glide.with(itemView.context).load(Constant.IMAGE_URL+model.poster_path).apply(RequestOptions.bitmapTransform(RoundedCorners(15))).into(ivMovie)
            }
        }

    }

}