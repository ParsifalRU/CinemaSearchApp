package dev.ivan_belyaev.film_by_id.data

import dev.ivan_belyaev.film_by_id.data.mapper.FilmReviewsDtoToDomainMapper
import dev.ivan_belyaev.film_by_id.domain.FilmReviewsRepository
import dev.ivan_belyaev.film_by_id.domain.model.FilmReviewsModel
import dev.ivan_belyaev.network.okhttp.ApiSetting
import javax.inject.Inject

class FilmReviewsRepositoryImpl @Inject constructor(
    private val api: FilmByIdApi,
    private val filmReviewsDtoToDomainMapper: FilmReviewsDtoToDomainMapper
) : FilmReviewsRepository {

    override suspend fun getReviews(filmId: String): FilmReviewsModel {
        return filmReviewsDtoToDomainMapper.invoke(
            api.requestReviews(
                token = ApiSetting.token,
                id = filmId
            )
        )
    }
}