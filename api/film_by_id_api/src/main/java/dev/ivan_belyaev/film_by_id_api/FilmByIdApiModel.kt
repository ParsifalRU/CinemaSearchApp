package dev.ivan_belyaev.film_by_id_api

import java.io.Serializable

data class FilmByIdApiModel(
    val filmId: Int
) : Serializable