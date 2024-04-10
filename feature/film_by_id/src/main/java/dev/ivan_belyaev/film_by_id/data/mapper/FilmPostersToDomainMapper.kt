package dev.ivan_belyaev.film_by_id.data.mapper

import dev.ivan_belyaev.film_by_id.data.dto.film_posters.FilmPostersDto
import dev.ivan_belyaev.film_by_id.domain.model.PostersFilmModel
import dev.ivan_belyaev.film_by_id.domain.model.PostersInfoFilmModel
import javax.inject.Inject

class FilmPostersToDomainMapper @Inject constructor() {

    operator fun invoke(postersFilmModel: FilmPostersDto) = with(postersFilmModel) {
        val postersInfoFilmList = docs.map { filmInfoModel ->
            PostersInfoFilmModel(
                url = filmInfoModel.url,
                id = filmInfoModel.id
            )
        }
        PostersFilmModel(
            docs = postersInfoFilmList
        )
    }
}