package dev.ivan_belyaev.film_by_id.api

import androidx.core.os.bundleOf
import dev.ivan_belyaev.core.navigation.NavData
import dev.ivan_belyaev.film_by_id_api.FilmByIdApiModel
import dev.ivan_belyaev.film_by_id_api.FilmByIdMediator
import dev.ivan_belyaev.filmbyid.R
import javax.inject.Inject

class FilmByIdMediatorImpl @Inject constructor() : FilmByIdMediator {

    override fun getFilmByIdScreenNavData(model: FilmByIdApiModel): NavData {
        return NavData(
            R.id.feature_film_by_id_nav_graph,
            bundleOf(FilmByIdMediator.MODEL_ID_EXTRA to model)
        )
    }
}