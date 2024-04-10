package dev.ivan_belyaev.film_by_id.data.dto.film_info

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

data class VotesModel(
    val kp: Int,
    val imdb: Int,
    val tmdb: Int,
    val filmCritics: Int,
    val russianFilmCritics: Int,
    val await: Int
)
