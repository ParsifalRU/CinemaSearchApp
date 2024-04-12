package dev.ivan_belyaev.film_by_id.data.dto

import dev.ivan_belyaev.film_by_id.data.FilmByIdApi
import dev.ivan_belyaev.film_by_id.data.mapper.FilmPostersToDomainMapper
import dev.ivan_belyaev.film_by_id.domain.FilmPostersRepository
import dev.ivan_belyaev.film_by_id.domain.model.PostersFilmModel
import dev.ivan_belyaev.network.okhttp.ApiSetting
import javax.inject.Inject

class FilmPostersRepositoryImpl @Inject constructor(
    private val api: FilmByIdApi,
    private val filmPostersToDomainMapper: FilmPostersToDomainMapper
) : FilmPostersRepository {

    override suspend fun getPosters(filmId: Int): PostersFilmModel {
        return filmPostersToDomainMapper.invoke(
            api.requestPosters(
                token = ApiSetting.token,
                id = filmId
            )
        )
    }
}