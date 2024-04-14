package dev.ivan_belyaev.film_by_id.presentation.adapter.film_reviews

import androidx.recyclerview.widget.DiffUtil

object ReviewsDiffUtil  : DiffUtil.ItemCallback<ReviewsModel>() {
    override fun areItemsTheSame(oldItem: ReviewsModel, newItem: ReviewsModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ReviewsModel, newItem: ReviewsModel): Boolean {
        return oldItem == newItem
    }
}