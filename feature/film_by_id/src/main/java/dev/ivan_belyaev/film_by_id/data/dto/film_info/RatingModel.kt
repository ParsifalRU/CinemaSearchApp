package dev.ivan_belyaev.film_by_id.data.dto.film_info


data class RatingModel(
    val kp: Double,
    val imdb: Double,
    val tmdb: Double,
    val filmCritics: Double,
    val russianFilmCritics: Double,
)
