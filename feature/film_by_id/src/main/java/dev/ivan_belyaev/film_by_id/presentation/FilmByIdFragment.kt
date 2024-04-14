package dev.ivan_belyaev.film_by_id.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import dev.ivan_belyaev.core.app.ApplicationProvider
import dev.ivan_belyaev.core.base.BaseFragment
import dev.ivan_belyaev.core.resources.AppResources
import dev.ivan_belyaev.coreui.listeners.setDebouncedClickListener
import dev.ivan_belyaev.film_by_id.di.FilmByIdComponent
import dev.ivan_belyaev.film_by_id.presentation.adapter.film_reviews.ReviewsListAdapter
import dev.ivan_belyaev.film_by_id.presentation.adapter.film_reviews.ReviewsModel
import dev.ivan_belyaev.film_by_id.presentation.adapter.posters.PostersListAdapter
import dev.ivan_belyaev.film_by_id.presentation.adapter.posters.PostersModel
import dev.ivan_belyaev.film_by_id.presentation.model.FilmReviewsUiModel
import dev.ivan_belyaev.film_by_id.presentation.model.FilmsByIdUiModel
import dev.ivan_belyaev.film_by_id.presentation.model.PostersFilmsUiModel
import dev.ivan_belyaev.film_by_id_api.FilmByIdApiModel
import dev.ivan_belyaev.film_by_id_api.FilmByIdMediator
import dev.ivan_belyaev.filmbyid.databinding.FragmentFilmByIdBinding
import javax.inject.Inject

class FilmByIdFragment :
    BaseFragment<FilmByIdViewModel, FragmentFilmByIdBinding>(
        FragmentFilmByIdBinding::inflate
    ) {

    @Inject
    lateinit var appResources: AppResources

    override val viewModel: FilmByIdViewModel by viewModels { viewModelFactory }

    private lateinit var adapterPosters: PostersListAdapter
    private var listPosters: List<PostersModel> = emptyList()
    private lateinit var adapterReviews: ReviewsListAdapter
    private var listReviews: List<ReviewsModel> = emptyList()

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        navigateToAllFilmsScreen()
        setRecyclerView()
        viewModel.state.observe { state -> renderState(state) }
        viewModel.posterState.observe { state -> renderPosterState(state) }
        viewModel.reviewsState.observe { state -> renderReviewState(state) }
    }

    private fun renderState(state: FilmsByIdUiModel) {
        with(binding) {
            textViewTitle.text = state.name
            textViewDescription.text = state.description
            textViewKpRatingText.text = state.rating.kp.toString()
            textViewImdbRatingText.text = state.rating.imdb.toString()
            textViewFilmCriticsRatingText.text = state.rating.filmCritics.toString()
            textViewRussianFilmCriticsRatingText.text = state.rating.russianFilmCritics.toString()
            binding.rootView.visibility = state.rootLayoutVisibility
            binding.downloadImageView.visibility = state.downloadLayoutVisibility
        }
    }

    private fun renderPosterState(posterState: PostersFilmsUiModel) {
        val arrayListPosters = ArrayList<PostersModel>()
        for (i in 0..posterState.docs.lastIndex) {
            arrayListPosters.add(
                PostersModel(
                    posterState.docs[i].url,
                    posterState.docs[i].id
                )
            )
        }
        listPosters = arrayListPosters
        if (listPosters.isEmpty()) {
            binding.recyclerViewPosters.visibility = View.GONE
        } else {
            binding.recyclerViewPosters.visibility = View.VISIBLE
            adapterPosters.submitList(listPosters)
        }
    }

    private fun renderReviewState(reviewState: FilmReviewsUiModel) {
        val arrayListReviews = ArrayList<ReviewsModel>()
        for (i in 0..reviewState.docs.lastIndex) {
            arrayListReviews.add(
                ReviewsModel(
                    reviewState.docs[i].id,
                    reviewState.docs[i].movieId,
                    reviewState.docs[i].title,
                    reviewState.docs[i].author,
                    reviewState.docs[i].type,
                    reviewState.docs[i].review,
                    reviewState.docs[i].date,
                )
            )
        }
        listReviews = arrayListReviews
        if (listReviews.isEmpty()) {
            binding.recyclerViewPosters.visibility = View.GONE
        } else {
            binding.recyclerViewPosters.visibility = View.VISIBLE
            adapterReviews.submitList(listReviews)
        }
    }

    private fun setRecyclerView() {
        val gridLayoutManagerPosters = GridLayoutManager(
            requireContext(), 1, GridLayoutManager.HORIZONTAL, false
        )
        binding.recyclerViewPosters.layoutManager = gridLayoutManagerPosters
        adapterPosters = PostersListAdapter()
        binding.recyclerViewPosters.adapter = adapterPosters

        val gridLayoutManagerReviews = GridLayoutManager(
            requireContext(), 1, GridLayoutManager.HORIZONTAL, false
        )
        binding.recyclerViewReviews.layoutManager = gridLayoutManagerReviews
        adapterReviews = ReviewsListAdapter()
        binding.recyclerViewReviews.adapter = adapterReviews
    }

    private fun navigateToAllFilmsScreen() {
        binding.buttonBack.setDebouncedClickListener {
            viewModel.navigateToAllFilmsScreen()
        }
    }

    override fun inject(applicationProvider: ApplicationProvider) {
        FilmByIdComponent.init(
            applicationProvider,
            requireArguments().getSerializable(
                FilmByIdMediator.MODEL_ID_EXTRA
            ) as FilmByIdApiModel
        ).inject(this)
    }
}