package dev.ivan_belyaev.film_by_id.data.mapper

import dev.ivan_belyaev.film_by_id.data.dto.film_reviews.FilmReviewsDto
import dev.ivan_belyaev.film_by_id.domain.model.FilmReviewInfoModel
import dev.ivan_belyaev.film_by_id.domain.model.FilmReviewsModel
import javax.inject.Inject

class FilmReviewsDtoToDomainMapper @Inject constructor() {

    operator fun invoke(filmReviewsDto: FilmReviewsDto) = with(filmReviewsDto) {
        val reviewsInfoFilmList = docs.map { filmInfoModel ->
            FilmReviewInfoModel(
                id = filmInfoModel.id,
                movieId = filmInfoModel.movieId,
                title = filmInfoModel.title,
                type = filmInfoModel.type,
                review = filmInfoModel.review,
                author = filmInfoModel.author,
                date = filmInfoModel.date,
            )
        }
        FilmReviewsModel(
            docs = reviewsInfoFilmList,
            total = total,
            limit = limit,
            page = page,
            pages = pages,
        )
    }
}