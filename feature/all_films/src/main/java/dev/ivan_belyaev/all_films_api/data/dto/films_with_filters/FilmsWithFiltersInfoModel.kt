package dev.ivan_belyaev.all_films_api.data.dto.films_with_filters

data class FilmsWithFiltersInfoModel(
    val id: Int,
    val names: List<InternalModel>,
)

data class InternalModel(
    val name: String
)
