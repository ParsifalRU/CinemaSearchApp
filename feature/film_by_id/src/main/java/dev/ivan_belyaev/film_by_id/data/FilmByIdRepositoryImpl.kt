package dev.ivan_belyaev.film_by_id.data

import dev.ivan_belyaev.film_by_id.data.mapper.FilmByIdDtoToDomainMapper
import dev.ivan_belyaev.film_by_id.domain.FilmByIdRepository
import dev.ivan_belyaev.film_by_id.domain.model.FilmByIdModel
import javax.inject.Inject

class FilmByIdRepositoryImpl
@Inject constructor(
    private val api: FilmByIdApi,
    private val filmByIdDtoToDomainMapper: FilmByIdDtoToDomainMapper
) : FilmByIdRepository {

    override suspend fun getAllFilms(): FilmByIdModel {
        return filmByIdDtoToDomainMapper.invoke(
            api.requestFilmById(
                token = ApiSetting.token,
                id = 666
            )
        )
    }
}