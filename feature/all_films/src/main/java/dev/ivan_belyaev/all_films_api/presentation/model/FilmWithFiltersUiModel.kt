package dev.ivan_belyaev.all_films_api.presentation.model

data class FilmWithFiltersUiModel(
    val docs: List<FilmWithFilterUiDetailModel>,
    val total: Int,
    val limit: Int,
    val page: Int,
    val pages: Int
)
