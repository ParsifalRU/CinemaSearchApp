package dev.ivan_belyaev.film_by_id.presentation.mapper

import dev.ivan_belyaev.film_by_id.domain.model.FilmByIdModel
import dev.ivan_belyaev.film_by_id.presentation.model.FilmsByIdUiModel
import javax.inject.Inject

class FilmByIdDomainToDetailsUiMapper @Inject constructor() {

    operator fun invoke(filmByIdModel: FilmByIdModel) = with(filmByIdModel) {

        FilmsByIdUiModel(
            name = name,
            description = description,
            rating = rating,
            votes = votes,
            poster = poster
        )
    }
}