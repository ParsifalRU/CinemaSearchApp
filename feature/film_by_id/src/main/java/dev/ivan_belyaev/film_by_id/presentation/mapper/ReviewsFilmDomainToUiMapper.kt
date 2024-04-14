package dev.ivan_belyaev.film_by_id.presentation.mapper

import dev.ivan_belyaev.film_by_id.domain.model.FilmReviewsModel
import dev.ivan_belyaev.film_by_id.presentation.model.FilmReviewsUiModel
import dev.ivan_belyaev.film_by_id.presentation.model.ReviewsFilmsInfoUiModel
import javax.inject.Inject

class ReviewsFilmDomainToUiMapper  @Inject constructor() {

    operator fun invoke(filmReviewsModel: FilmReviewsModel) = with(filmReviewsModel) {
        val reviewsInfoUiList = docs.map { reviewsInfoFilmModel ->
            ReviewsFilmsInfoUiModel(
                id = reviewsInfoFilmModel.id,
                movieId = reviewsInfoFilmModel.movieId,
                title = reviewsInfoFilmModel.title,
                type = reviewsInfoFilmModel.type,
                review = reviewsInfoFilmModel.review,
                date = reviewsInfoFilmModel.date,
                author = reviewsInfoFilmModel.author,
            )
        }
        FilmReviewsUiModel(
            docs = reviewsInfoUiList,
            limit = limit,
            page = page,
            pages = pages,
            total = total
        )
    }
}