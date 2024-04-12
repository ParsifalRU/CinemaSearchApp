package dev.ivan_belyaev.film_by_id.presentation.adapter

import androidx.recyclerview.widget.DiffUtil

object PostersDiffUtil: DiffUtil.ItemCallback<PostersModel>() {
    override fun areItemsTheSame(oldItem: PostersModel, newItem: PostersModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: PostersModel, newItem: PostersModel): Boolean {
        return oldItem == newItem
    }
}