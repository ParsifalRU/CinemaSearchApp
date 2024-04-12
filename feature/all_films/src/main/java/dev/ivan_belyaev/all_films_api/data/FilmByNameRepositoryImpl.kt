package dev.ivan_belyaev.all_films_api.data

import dev.ivan_belyaev.all_films_api.data.mapper.FilmByNameDtoToDomainMapper
import dev.ivan_belyaev.all_films_api.domain.FilmByNameRepository
import dev.ivan_belyaev.all_films_api.domain.model.FilmByNameModel
import dev.ivan_belyaev.network.okhttp.ApiSetting
import javax.inject.Inject

class FilmByNameRepositoryImpl
@Inject constructor(
    private val api: AllFilmsApi,
    private val filmByNameToDomainMapper: FilmByNameDtoToDomainMapper
) : FilmByNameRepository {

    override suspend fun getFilmsByName(page: Int, limit: Int, query: String): FilmByNameModel {
        return filmByNameToDomainMapper.invoke(
            api.fetchFilmByName(
                token = ApiSetting.token,
                page = page,
                limit = limit,
                query = query
            )
        )
    }

}