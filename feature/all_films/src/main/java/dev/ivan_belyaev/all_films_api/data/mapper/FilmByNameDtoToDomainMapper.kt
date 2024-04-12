package dev.ivan_belyaev.all_films_api.data.mapper

import dev.ivan_belyaev.all_films_api.data.dto.film_by_name.FilmByNameDto
import dev.ivan_belyaev.all_films_api.domain.model.FilmByNameModel
import dev.ivan_belyaev.all_films_api.domain.model.FilmsByNameInfoModel
import javax.inject.Inject

class FilmByNameDtoToDomainMapper @Inject constructor() {

    operator fun invoke(filmByNameDto: FilmByNameDto) = with(filmByNameDto) {
        val filmByNameInfoModel = docs.map { byNameInfoModel ->
            FilmsByNameInfoModel(
                internalNames = byNameInfoModel.internalNames[0],
                id = byNameInfoModel.id
            )
        }
        FilmByNameModel(
            docs = filmByNameInfoModel,
            total = total,
            limit = limit,
            page = page,
            pages = pages
        )
    }
}