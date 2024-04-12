package dev.ivan_belyaev.all_films_api.presentation.mapper

import dev.ivan_belyaev.all_films_api.domain.model.FilmWithFiltersModel
import dev.ivan_belyaev.all_films_api.presentation.model.FilmWithFilterUiDetailModel
import dev.ivan_belyaev.all_films_api.presentation.model.FilmWithFiltersUiModel
import javax.inject.Inject

class FilmWithFilterDomainToUiMapper @Inject constructor() {

    operator fun invoke(filmWithFiltersModel: FilmWithFiltersModel) = with(filmWithFiltersModel) {
        val filmWithFiltersUiDetailModel = docs.map { byFiltersDetailModel ->
            FilmWithFilterUiDetailModel(
                name = byFiltersDetailModel.name,
                id = byFiltersDetailModel.id
            )
        }
        FilmWithFiltersUiModel(
            docs = filmWithFiltersUiDetailModel,
            total = total,
            limit = limit,
            page = page,
            pages = pages
        )
    }
}