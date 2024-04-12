package dev.ivan_belyaev.all_films_api.presentation.adapter

import androidx.recyclerview.widget.DiffUtil

object AllFilmsDiffUtil: DiffUtil.ItemCallback<AllFilmsModel>() {
    override fun areItemsTheSame(oldItem: AllFilmsModel, newItem: AllFilmsModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: AllFilmsModel, newItem: AllFilmsModel): Boolean {
        return oldItem == newItem
    }
}