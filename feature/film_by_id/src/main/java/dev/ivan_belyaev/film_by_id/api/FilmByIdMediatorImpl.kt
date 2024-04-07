package dev.ivan_belyaev.film_by_id.api

import dev.ivan_belyaev.core.navigation.NavData
import dev.ivan_belyaev.film_by_id_api.FilmByIdMediator
import dev.ivan_belyaev.filmbyid.R
import javax.inject.Inject

class FilmByIdMediatorImpl @Inject constructor(): FilmByIdMediator {

    override fun getFilmByIdScreenNavData(): NavData {
        return NavData(
            R.id.feature_film_by_id_nav_graph
        )
    }
}