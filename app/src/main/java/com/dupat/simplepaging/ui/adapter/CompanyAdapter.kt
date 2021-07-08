package com.dupat.simplepaging.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dupat.simplepaging.R
import com.dupat.simplepaging.databinding.ItemCompanyListBinding
import com.dupat.simplepaging.ui.Utils.Constant
import com.dupat.simplepaging.ui.model.ProductionCompanyModel

class CompanyAdapter(private val companies: List<ProductionCompanyModel>): RecyclerView.Adapter<CompanyAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompanyAdapter.ViewHolder {
        val binding = ItemCompanyListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CompanyAdapter.ViewHolder, position: Int) {
        holder.bind(companies[position])
    }

    override fun getItemCount() = companies.size

    inner class ViewHolder(private val binding: ItemCompanyListBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(model: ProductionCompanyModel){
            with(binding){
                txtTitle.text = model.name
                Glide.with(itemView.context).load(if (model.logo_path == null) R.drawable.comapny else Constant.IMAGE_URL+model.logo_path).into(ivCompany)
            }
        }

    }
}