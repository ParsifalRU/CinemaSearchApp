package dev.ivan_belyaev.all_films_api.domain.model

data class FilmByNameModel(
    val docs: List<FilmsByNameInfoModel>,
    val total: Int,
    val limit: Int,
    val page: Int,
    val pages: Int
)