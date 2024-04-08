package dev.ivan_belyaev.film_by_id.domain

import dev.ivan_belyaev.film_by_id.data.Response

interface FilmByIdRepository {

    suspend fun getAllFilms(): Response
}