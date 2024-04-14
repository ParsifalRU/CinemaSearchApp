package dev.ivan_belyaev.all_films_api.data.dto.film_by_name

data class FilmByNameDto(
    val docs: List<FilmsByNameInfo> = emptyList(),
    val total: Int,
    val limit: Int,
    val page: Int,
    val pages: Int
)
