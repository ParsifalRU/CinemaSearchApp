package dev.ivan_belyaev.film_by_id.presentation

import android.util.Log
import dev.ivan_belyaev.core.base.BaseViewModel
import dev.ivan_belyaev.film_by_id.data.dto.film_info.PosterModel
import dev.ivan_belyaev.film_by_id.data.dto.film_info.RatingModel
import dev.ivan_belyaev.film_by_id.data.dto.film_info.VotesModel
import dev.ivan_belyaev.film_by_id.domain.FilmByIdRepository
import dev.ivan_belyaev.film_by_id.domain.FilmPostersRepository
import dev.ivan_belyaev.film_by_id.presentation.mapper.FilmByIdDomainToDetailsUiMapper
import dev.ivan_belyaev.film_by_id.presentation.mapper.PostersFilmsDomainToUiMapper
import dev.ivan_belyaev.film_by_id.presentation.model.FilmsByIdUiModel
import dev.ivan_belyaev.film_by_id.presentation.model.PostersFilmsUiModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.withContext
import javax.inject.Inject

class FilmByIdViewModel @Inject constructor(
    private val filmByIdRepository: FilmByIdRepository,
    private val filmPostersRepository: FilmPostersRepository,
    private val filmByIdDomainToDetailsUiMapper: FilmByIdDomainToDetailsUiMapper,
    private val postersFilmsDomainToUiMapper: PostersFilmsDomainToUiMapper
) : BaseViewModel() {

    private val _fragmentState = MutableStateFlow(getUiState())
    val state: StateFlow<FilmsByIdUiModel> = _fragmentState

    private val _posterState = MutableStateFlow(getPostersState())
    val posterState: StateFlow<PostersFilmsUiModel> = _posterState

    init {
       launch {
           try {
               testGetRequest()
               fetchPosters()
           }catch (e:Exception){
               Log.d("LOGTAG", "Ошибка " + e.toString() + e.cause + e.message)
           }
       }
    }

    fun getUiState(): FilmsByIdUiModel {
        return FilmsByIdUiModel(
            name = "name",
            description = "description",
            rating = RatingModel(1.0,2.0,3.0,4.0,5.0),
            votes = VotesModel(1,2,3,4,5,6),
            poster = PosterModel("1","2"),
        )
    }

    fun getPostersState(): PostersFilmsUiModel {
        return PostersFilmsUiModel(
            emptyList()
        )
    }

    suspend fun fetchPosters() {
        withContext(Dispatchers.IO) {
            val result = postersFilmsDomainToUiMapper.invoke(filmPostersRepository.getPosters())
            _posterState.update {
                _posterState.value.copy(
                    docs = result.docs
                )
            }
        }
    }


    suspend fun testGetRequest(){
        withContext(Dispatchers.IO) {
             val result = filmByIdDomainToDetailsUiMapper.invoke(filmByIdRepository.getAllFilms())
            _fragmentState.update {
                _fragmentState.value.copy(
                    name = result.name,
                    description = result.description,
                    rating = result.rating,
                    votes = result.votes,
                    poster = result.poster,
                )
            }
        }
    }
}