package dev.ivan_belyaev.all_films_api.data.dto.films_with_filters

data class FilmsWithFiltersDto(
    val docs: List<FilmsWithFiltersInfoModel>,
    val total: Int,
    val limit: Int,
    val page: Int,
    val pages: Int
)
