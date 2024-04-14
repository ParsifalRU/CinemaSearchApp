package dev.ivan_belyaev.film_by_id.domain

import dev.ivan_belyaev.film_by_id.domain.model.FilmReviewsModel

interface FilmReviewsRepository {

    suspend fun getReviews(filmId: String): FilmReviewsModel
}