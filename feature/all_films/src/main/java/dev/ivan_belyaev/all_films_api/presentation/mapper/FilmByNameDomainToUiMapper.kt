package dev.ivan_belyaev.all_films_api.presentation.mapper

import dev.ivan_belyaev.all_films_api.domain.model.FilmByNameModel
import dev.ivan_belyaev.all_films_api.presentation.model.FilmByNameUiDetailModel
import dev.ivan_belyaev.all_films_api.presentation.model.FilmByNameUiModel
import javax.inject.Inject

class FilmByNameDomainToUiMapper @Inject constructor() {

    operator fun invoke(filmByNameModel: FilmByNameModel) = with(filmByNameModel) {
        val filmByNameUiDetailModel = docs.map { byNameDetailModel ->
            FilmByNameUiDetailModel(
                internalNames = byNameDetailModel.internalNames,
                id = byNameDetailModel.id
            )
        }
        FilmByNameUiModel(
            docs = filmByNameUiDetailModel,
            total = total,
            limit = limit,
            page = page,
            pages = pages
        )
    }
}