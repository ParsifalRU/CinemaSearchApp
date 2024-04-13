package dev.ivan_belyaev.all_films_api.presentation.mapper

import dev.ivan_belyaev.all_films_api.domain.model.FilmWithFiltersModel
import dev.ivan_belyaev.all_films_api.presentation.model.FilmByNameUiDetailModel
import dev.ivan_belyaev.all_films_api.presentation.model.FilmByNameUiModel
import javax.inject.Inject

class FilmWithFilterDomainToUiMapper @Inject constructor() {

    operator fun invoke(filmWithFiltersModel: FilmWithFiltersModel) = with(filmWithFiltersModel) {
        val filmWithFiltersUiDetailModel = docs.map { byFiltersDetailModel ->
            FilmByNameUiDetailModel(
                internalNames = byFiltersDetailModel.name,
                id = byFiltersDetailModel.id
            )
        }
        FilmByNameUiModel(
            docs = filmWithFiltersUiDetailModel,
            total = total,
            limit = limit,
            page = page,
            pages = pages
        )
    }
}