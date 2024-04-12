package dev.ivan_belyaev.all_films_api.domain

import dev.ivan_belyaev.all_films_api.domain.model.FilmByNameModel

interface FilmByNameRepository {

    suspend fun getFilmsByName(page: Int, limit: Int, query: String): FilmByNameModel
}