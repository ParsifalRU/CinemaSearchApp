package dev.ivan_belyaev.film_by_id_api

import dev.ivan_belyaev.core.navigation.NavData

interface FilmByIdMediator {

    companion object {
        const val MODEL_ID_EXTRA = "FILM_BY_ID_NAV_DATA_MODEL_ID_EXTRA"
    }

    fun getFilmByIdScreenNavData(model: FilmByIdApiModel): NavData
}