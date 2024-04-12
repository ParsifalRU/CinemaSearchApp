package dev.ivan_belyaev.all_films_api.presentation.model

data class FilmByNameUiModel(
    val docs: List<FilmByNameUiDetailModel>,
    val total: Int,
    val limit: Int,
    val page: Int,
    val pages: Int
)