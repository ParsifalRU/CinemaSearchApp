package dev.ivan_belyaev.all_films_api.presentation.viewmodel

import android.util.Log
import dev.ivan_belyaev.all_films_api.domain.FilmByNameRepository
import dev.ivan_belyaev.all_films_api.domain.FilmWithFiltersRepository
import dev.ivan_belyaev.all_films_api.presentation.mapper.FilmByNameDomainToUiMapper
import dev.ivan_belyaev.all_films_api.presentation.mapper.FilmWithFilterDomainToUiMapper
import dev.ivan_belyaev.all_films_api.presentation.model.FilmByNameUiDetailModel
import dev.ivan_belyaev.all_films_api.presentation.model.FilmByNameUiModel
import dev.ivan_belyaev.core.base.BaseViewModel
import dev.ivan_belyaev.core.wrapper.SharedPreferencesWrapper
import dev.ivan_belyaev.film_by_id_api.FilmByIdApiModel
import dev.ivan_belyaev.film_by_id_api.FilmByIdMediator
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AllFilmsViewModel  @Inject constructor(
    private val filmByIdMediator: FilmByIdMediator,
    private val filmByNameDomainToUiMapper: FilmByNameDomainToUiMapper,
    private val filmWithFilterDomainToUiMapper: FilmWithFilterDomainToUiMapper,
    private val filmByNameRepository: FilmByNameRepository,
    private val filmWithFiltersRepository: FilmWithFiltersRepository,
    private val sharedPreferencesWrapper: SharedPreferencesWrapper
) : BaseViewModel() {

    private val _fragmentState = MutableStateFlow(getUiState())
    val state: StateFlow<FilmByNameUiModel> = _fragmentState

    init {
        launch {
            try {
                updateFilmsWithFiltersList(null, null, null)
            }catch (e:Exception){
                Log.d("LOGTAG", "Ошибка " + e.toString() + e.cause + e.message)
            }
        }
    }

    private fun getUiState(): FilmByNameUiModel {
        return FilmByNameUiModel(
            docs = listOf(FilmByNameUiDetailModel("",1)),
            total = 0,
            limit = 0,
            page = 1,
            pages = 0
        )
    }

    private suspend fun fetchFilmByName(page: Int = getUiState().page, limit: Int = 10, query : String = "null"){
        if (query != "null"){
            withContext(Dispatchers.IO) {
                val result = filmByNameDomainToUiMapper.invoke(filmByNameRepository.getFilmsByName(
                    page,
                    limit,
                    query
                ))
                _fragmentState.update {
                    _fragmentState.value.copy(
                        docs = result.docs,
                        total = result.total,
                        limit = result.limit,
                        page = result.page,
                        pages = result.pages
                    )
                }
            }
        }
    }

    fun updateFilmsList(filmName : String, page: Int){
        _fragmentState.update {
            _fragmentState.value.copy(
                page = page
            )
        }
        launch { fetchFilmByName(query = filmName, page = _fragmentState.value.page) }
    }

    fun nextPageFilmList(actualFilmName: String){
        launch {
            fetchFilmByName(query = actualFilmName, page = _fragmentState.value.page + 1 )
        }
        _fragmentState.update {
            _fragmentState.value.copy(
                page = _fragmentState.value.page
            )
        }
    }

    fun previousPageFilmList(actualFilmName: String){
        launch {
            fetchFilmByName(query = actualFilmName, page = _fragmentState.value.page - 1 )
        }
        _fragmentState.update {
            _fragmentState.value.copy(
                page = _fragmentState.value.page
            )
        }
    }

    fun nextPageWithFilterFilms(
        countriesName: Array<String>?,
        premiereCinema: Array<String>?,
        ageRating: Array<String>?
    ){
        launch {
            fetchFilmsWithFilters(
                page = _fragmentState.value.page + 1,
                limit = 10,
                countriesName = countriesName,
                premiereCinema = premiereCinema,
                ageRating = ageRating
            )
        }
        _fragmentState.update {
            _fragmentState.value.copy(
                page = _fragmentState.value.page
            )
        }
    }

    fun previousPageWithFilterFilms(
        countriesName: Array<String>?,
        premiereCinema: Array<String>?,
        ageRating: Array<String>?){
        launch {
            fetchFilmsWithFilters(
                page = _fragmentState.value.page - 1,
                limit = 10,
                countriesName = countriesName,
                premiereCinema = premiereCinema,
                ageRating = ageRating
            )
        }
        _fragmentState.update {
            _fragmentState.value.copy(
                page = _fragmentState.value.page
            )
        }
    }

    fun updateFilmsWithFiltersList(
        countriesName: Array<String>?,
        premiereCinema: Array<String>?,
        ageRating: Array<String>?){

        launch { fetchFilmsWithFilters(
            page = 1,
            limit = 10,
            countriesName = countriesName,
            premiereCinema = premiereCinema,
            ageRating = ageRating
        )}
    }

    private suspend fun fetchFilmsWithFilters(
        page: Int,
        limit: Int,
        countriesName: Array<String>?,
        premiereCinema: Array<String>?,
        ageRating: Array<String>?
    ){
        withContext(Dispatchers.IO) {
            val result = filmWithFilterDomainToUiMapper.invoke(filmWithFiltersRepository.getFilmsWithFilters(
                page = page,
                limit = limit,
                countriesName = countriesName,
                premiereCinema = premiereCinema,
                ageRating = ageRating
            ))
            _fragmentState.update {
                _fragmentState.value.copy(
                    docs = result.docs,
                    total = result.total,
                    limit = result.limit,
                    page = result.page,
                    pages = result.pages
                )
            }
        }
    }

    fun navigateToFilmByIdScreen(filmID: Int){
        navigate(filmByIdMediator.getFilmByIdScreenNavData(FilmByIdApiModel(filmID)))
    }
}