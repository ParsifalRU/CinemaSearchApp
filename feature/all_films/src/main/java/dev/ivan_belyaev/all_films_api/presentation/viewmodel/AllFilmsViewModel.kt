package dev.ivan_belyaev.all_films_api.presentation.viewmodel

import android.util.Log
import dev.ivan_belyaev.all_films_api.domain.FilmByNameRepository
import dev.ivan_belyaev.all_films_api.presentation.mapper.FilmByNameDomainToUiMapper
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
    private val filmByNameRepository: FilmByNameRepository,
    private val sharedPreferencesWrapper: SharedPreferencesWrapper
) : BaseViewModel() {

    private val _fragmentState = MutableStateFlow(getUiState())
    val state: StateFlow<FilmByNameUiModel> = _fragmentState

    private val _namesState = MutableStateFlow(getUiState())
    val namesState: StateFlow<FilmByNameUiModel> = _namesState

    init {
        launch {
            try {
                fetchFilmByName()
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
            page = 0,
            pages = 0
        )
    }


    private suspend fun fetchFilmByName(page: Int = 1, limit: Int = 10, query : String = "null"){
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

    fun onPhoneNumberChanged(text: String) {
/*        val error = when {
            !text.matches(phoneNumberRegex) && text.isNotBlank() -> R.string.phone_text_error_invalid
            else -> null
        }

        _viewState.value = _viewState.value.copy(
            phoneNumberState = _viewState.value.phoneNumberState.copy(
                R.string.phone_number,
                error = error,
                phoneNumber = text,
                background = getBackgroundErrorDrawable(error)
            )
        )*/
    }

    fun getSharedPreference(){

    }

    fun recommendationList(){

    }

    fun updateFilmsList(filmName : String){

            launch { fetchFilmByName(query = filmName) }
            /*sharedPreferencesWrapper.getValue()*/

    }

    fun navigateToFilmByIdScreen(filmID: Int){
        navigate(filmByIdMediator.getFilmByIdScreenNavData(FilmByIdApiModel(filmID)))
    }

}