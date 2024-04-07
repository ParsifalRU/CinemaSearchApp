package dev.ivan_belyaev.film_by_id_api

import dev.ivan_belyaev.core.navigation.NavData

interface FilmByIdMediator {

    fun getFilmByIdScreenNavData(): NavData
}