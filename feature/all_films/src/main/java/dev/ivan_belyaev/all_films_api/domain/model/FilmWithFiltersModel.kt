package dev.ivan_belyaev.all_films_api.domain.model

import dev.ivan_belyaev.all_films_api.data.dto.films_with_filters.FilmsWithFiltersInfoModel

data class FilmWithFiltersModel(
    val docs: List<FilmsWithFiltersInfoModel>,
    val total: Int,
    val limit: Int,
    val page: Int,
    val pages: Int
)
