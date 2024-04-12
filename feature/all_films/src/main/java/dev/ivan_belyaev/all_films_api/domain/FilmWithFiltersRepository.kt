package dev.ivan_belyaev.all_films_api.domain

import dev.ivan_belyaev.all_films_api.domain.model.FilmWithFiltersModel

interface FilmWithFiltersRepository {

    suspend fun getFilmsWithFilters(
        page: Int,
        limit: Int,
        countriesName: Array<String>?,
        premiereCinema: Array<String>?,
        ageRating: Array<String>?
    ): FilmWithFiltersModel
}