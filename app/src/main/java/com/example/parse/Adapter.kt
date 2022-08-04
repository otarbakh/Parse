package com.example.parse

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.parse.Model.HomeModel
import com.example.parse.databinding.DetailsBinding

class Adapter :
    ListAdapter<HomeModel.Content, Adapter.HomeModelViewHolder>(DiffCallBack()) {

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): HomeModelViewHolder {
        val binding =
            DetailsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeModelViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeModelViewHolder, position: Int) {
        holder.bindData()
    }

    inner class HomeModelViewHolder(private val binding: DetailsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData() {
            val homeCard = getItem(adapterPosition)
            binding.apply {
                binding.tvTitleKA.text = "${homeCard.titleKA.toString()}"
                binding.tvDescriptionKA.text = homeCard.descriptionKA
                binding.tvPublishDate.text =
                    "განცხადების დადების თარიღი: \n${homeCard.publishDate.toString()}"
                Glide.with(this.ImCover)
                    .load(homeCard.cover)
                    .into(ImCover)
            }
        }
    }

    class DiffCallBack : DiffUtil.ItemCallback<HomeModel.Content>() {
        override fun areItemsTheSame(
            oldItem: HomeModel.Content,
            newItem: HomeModel.Content
        ): Boolean {
            return oldItem.titleKA == newItem.titleKA
        }

        override fun areContentsTheSame(
            oldItem: HomeModel.Content, newItem: HomeModel.Content
        ): Boolean {
            return oldItem == newItem
        }
    }
}