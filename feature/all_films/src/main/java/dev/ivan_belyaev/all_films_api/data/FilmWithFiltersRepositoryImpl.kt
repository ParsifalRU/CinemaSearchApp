package dev.ivan_belyaev.all_films_api.data

import dev.ivan_belyaev.all_films_api.data.mapper.FilmsWithFiltersDtoToDomainMapper
import dev.ivan_belyaev.all_films_api.domain.FilmWithFiltersRepository
import dev.ivan_belyaev.all_films_api.domain.model.FilmWithFiltersModel
import dev.ivan_belyaev.network.okhttp.ApiSetting
import javax.inject.Inject

class FilmWithFiltersRepositoryImpl @Inject constructor(
    private val api: AllFilmsApi,
    private val filmWithFiltersToDomainMapper: FilmsWithFiltersDtoToDomainMapper
) : FilmWithFiltersRepository {

    override suspend fun getFilmsWithFilters(
        page: Int,
        limit: Int,
        query: String,
        countriesName: Array<String>?,
        premiereCinema: Array<String>?,
        ageRating: Array<String>?
    ): FilmWithFiltersModel {
        return filmWithFiltersToDomainMapper.invoke(
            api.fetchFilmsWithFilters(
                token = ApiSetting.token,
                page = page,
                limit = limit,
                query = query,
                ageRating = ageRating,
                countriesName = countriesName,
                premiereCinema = premiereCinema,

            )
        )
    }
}