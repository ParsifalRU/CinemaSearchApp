package dev.ivan_belyaev.all_films_api.api

import dev.ivan_belyaev.all_films.R
import dev.ivan_belyaev.all_films_api.AllFilmsMediator
import dev.ivan_belyaev.core.navigation.NavData
import javax.inject.Inject

class AllFilmsMediatorImpl @Inject constructor(): AllFilmsMediator {
    override fun getAllFilmsScreenNavData(): NavData {
        return NavData(
            R.id.feature_all_films_nav_graph
        )
    }
}