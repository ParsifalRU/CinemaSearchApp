package dev.ivan_belyaev.film_by_id.domain

import dev.ivan_belyaev.film_by_id.domain.model.FilmByIdModel

interface FilmByIdRepository {

    suspend fun getAllFilms(filmId: Int): FilmByIdModel
}