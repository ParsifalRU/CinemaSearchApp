package dev.ivan_belyaev.all_films_api.data.dto.film_by_name

data class FilmsByNameInfo(
    val internalNames: List<String>,
    val id: Int = 0
)