package dev.ivan_belyaev.film_by_id.data

import dev.ivan_belyaev.film_by_id.domain.FilmByIdRepository
import javax.inject.Inject

class FilmByIdRepositoryImpl
@Inject constructor(
    private val api: FilmByIdApi,
) : FilmByIdRepository {

    override suspend fun getAllFilms(): Response {
        return api.requestFilmById(
            token = ApiSetting.token,
            id = 456
        )
    }

}