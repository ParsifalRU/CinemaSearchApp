package dev.ivan_belyaev.all_films_api.data.mapper

import dev.ivan_belyaev.all_films_api.data.dto.films_with_filters.FilmsWithFiltersDto
import dev.ivan_belyaev.all_films_api.data.dto.films_with_filters.FilmsWithFiltersInfoModel
import dev.ivan_belyaev.all_films_api.domain.model.FilmWithFiltersModel
import javax.inject.Inject

class FilmsWithFiltersDtoToDomainMapper @Inject constructor() {

    operator fun invoke(filmsWithFiltersDto: FilmsWithFiltersDto) = with(filmsWithFiltersDto) {
        val filmsWithFiltersInfoModel = docs.map { withFiltersInfoModel ->
            FilmsWithFiltersInfoModel(
                name = withFiltersInfoModel.name,
                id = withFiltersInfoModel.id
            )
        }
        FilmWithFiltersModel(
            docs = filmsWithFiltersInfoModel,
            total = total,
            limit = limit,
            page = page,
            pages = pages
        )
    }
}