package dev.ivan_belyaev.film_by_id.domain

import dev.ivan_belyaev.film_by_id.domain.model.PostersFilmModel

interface FilmPostersRepository {

    suspend fun getPosters(filmId: Int): PostersFilmModel
}