package dev.ivan_belyaev.film_by_id.presentation

import android.util.Log
import android.view.View
import dev.ivan_belyaev.core.base.BaseViewModel
import dev.ivan_belyaev.film_by_id.data.dto.film_info.PosterModel
import dev.ivan_belyaev.film_by_id.data.dto.film_info.RatingModel
import dev.ivan_belyaev.film_by_id.data.dto.film_info.VotesModel
import dev.ivan_belyaev.film_by_id.domain.FilmByIdRepository
import dev.ivan_belyaev.film_by_id.domain.FilmPostersRepository
import dev.ivan_belyaev.film_by_id.domain.FilmReviewsRepository
import dev.ivan_belyaev.film_by_id.presentation.mapper.FilmByIdDomainToDetailsUiMapper
import dev.ivan_belyaev.film_by_id.presentation.mapper.PostersFilmsDomainToUiMapper
import dev.ivan_belyaev.film_by_id.presentation.mapper.ReviewsFilmDomainToUiMapper
import dev.ivan_belyaev.film_by_id.presentation.model.FilmReviewsUiModel
import dev.ivan_belyaev.film_by_id.presentation.model.FilmsByIdUiModel
import dev.ivan_belyaev.film_by_id.presentation.model.PostersFilmsUiModel
import dev.ivan_belyaev.film_by_id_api.FilmByIdApiModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.withContext
import javax.inject.Inject

class FilmByIdViewModel @Inject constructor(
    private val filmByIdRepository: FilmByIdRepository,
    private val filmPostersRepository: FilmPostersRepository,
    private val filmReviewsRepository: FilmReviewsRepository,
    private val filmByIdDomainToDetailsUiMapper: FilmByIdDomainToDetailsUiMapper,
    private val postersFilmsDomainToUiMapper: PostersFilmsDomainToUiMapper,
    private val reviewsFilmDomainToUiMapper: ReviewsFilmDomainToUiMapper,
    private val filmIdNumber: FilmByIdApiModel
) : BaseViewModel() {

    private val _fragmentState = MutableStateFlow(getUiState())
    val state: StateFlow<FilmsByIdUiModel> = _fragmentState

    private val _posterState = MutableStateFlow(getPostersState())
    val posterState: StateFlow<PostersFilmsUiModel> = _posterState

    private val _reviewsState = MutableStateFlow(getReviewsState())
    val reviewsState: StateFlow<FilmReviewsUiModel> = _reviewsState

    init {
        launch {
            try {
                fetchFilmInfo()
                fetchPosters()
                fetchReviews()
            } catch (e: Exception) {
                Log.d("LOGTAG", "Ошибка " + e.toString() + e.cause + e.message)
            }
        }
    }

    private fun getUiState(): FilmsByIdUiModel {
        return FilmsByIdUiModel(
            name = "name",
            description = "description",
            rating = RatingModel(1.0, 2.0, 3.0, 4.0, 5.0),
            votes = VotesModel(1, 2, 3, 4, 5, 6),
            poster = PosterModel("1", "2"),
            rootLayoutVisibility = View.GONE,
            downloadLayoutVisibility = View.VISIBLE
        )
    }

    private fun getPostersState(): PostersFilmsUiModel {
        return PostersFilmsUiModel(
            emptyList()
        )
    }

    private fun getReviewsState(): FilmReviewsUiModel {
        return FilmReviewsUiModel(
            emptyList(),
            total = 10,
            limit = 10,
            pages = 10,
            page = 1
        )
    }

    private suspend fun fetchPosters() {
        withContext(Dispatchers.IO) {
            val result =
                postersFilmsDomainToUiMapper.invoke(filmPostersRepository.getPosters(filmIdNumber.filmId))
            _posterState.update {
                _posterState.value.copy(
                    docs = result.docs
                )
            }
        }
    }

    private suspend fun fetchReviews() {
        withContext(Dispatchers.IO) {
            val result = reviewsFilmDomainToUiMapper.invoke(
                filmReviewsRepository.getReviews(filmIdNumber.filmId.toString())
            )
            _reviewsState.update {
                _reviewsState.value.copy(
                    docs = result.docs,
                    total = result.total,
                    limit = result.limit,
                    page = result.page,
                    pages = result.pages
                )
            }
        }
    }

    private suspend fun fetchFilmInfo() {
        withContext(Dispatchers.IO) {
            val result = filmByIdDomainToDetailsUiMapper.invoke(
                filmByIdRepository.getAllFilms(filmIdNumber.filmId)
            )
            _fragmentState.update {
                _fragmentState.value.copy(
                    name = result.name,
                    description = result.description,
                    rating = result.rating,
                    votes = result.votes,
                    poster = result.poster,
                    rootLayoutVisibility = View.VISIBLE,
                    downloadLayoutVisibility = View.GONE
                )
            }
        }
    }

    fun navigateToAllFilmsScreen() {
        navigateBack()
    }
}