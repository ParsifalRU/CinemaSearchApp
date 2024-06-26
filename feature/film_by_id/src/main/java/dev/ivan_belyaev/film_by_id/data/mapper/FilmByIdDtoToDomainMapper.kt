package dev.ivan_belyaev.film_by_id.data.mapper

import dev.ivan_belyaev.film_by_id.data.dto.film_info.FilmByIdDto
import dev.ivan_belyaev.film_by_id.domain.model.FilmByIdModel
import javax.inject.Inject

class FilmByIdDtoToDomainMapper @Inject constructor() {

    operator fun invoke(filmByIdModel: FilmByIdDto) = with(filmByIdModel) {
        FilmByIdModel(
            name = names[0].name,
            description = description ?: "Нет информации",
            rating = rating,
            votes = votes,
            poster = poster
        )
    }
}