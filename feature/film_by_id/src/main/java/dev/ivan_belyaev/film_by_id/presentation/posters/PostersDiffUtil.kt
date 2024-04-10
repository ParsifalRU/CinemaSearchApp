package dev.ivan_belyaev.film_by_id.presentation.posters

import androidx.recyclerview.widget.DiffUtil

object PostersDiffUtil: DiffUtil.ItemCallback<PostersModel>() {
    override fun areItemsTheSame(oldItem: PostersModel, newItem: PostersModel): Boolean {
        return oldItem.id.toInt() == newItem.id.toInt()
    }

    override fun areContentsTheSame(oldItem: PostersModel, newItem: PostersModel): Boolean {
        return oldItem == newItem
    }
}