package dev.ivan_belyaev.film_by_id.presentation.mapper

import dev.ivan_belyaev.film_by_id.domain.model.PostersFilmModel
import dev.ivan_belyaev.film_by_id.presentation.model.PosterFilmsInfoUiModel
import dev.ivan_belyaev.film_by_id.presentation.model.PostersFilmsUiModel
import javax.inject.Inject

class PostersFilmsDomainToUiMapper @Inject constructor() {

    operator fun invoke(postersFilmModel: PostersFilmModel) = with(postersFilmModel) {
        val postersInfoUiList = docs.map { postersInfoFilmModel ->
            PosterFilmsInfoUiModel(
                url = postersInfoFilmModel.url,
                id = postersInfoFilmModel.id
            )
        }
        PostersFilmsUiModel(
            docs = postersInfoUiList
        )
    }
}