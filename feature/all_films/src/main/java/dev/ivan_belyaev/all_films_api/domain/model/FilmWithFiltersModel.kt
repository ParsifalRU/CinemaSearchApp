package dev.ivan_belyaev.all_films_api.domain.model

data class FilmWithFiltersModel(
    val docs: List<FilmWithFiltersInfoModel>,
    val total: Int,
    val limit: Int,
    val page: Int,
    val pages: Int
)
