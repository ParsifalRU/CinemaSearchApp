package dev.ivan_belyaev.film_by_id.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import dev.ivan_belyaev.core.app.ApplicationProvider
import dev.ivan_belyaev.core.base.BaseFragment
import dev.ivan_belyaev.core.resources.AppResources
import dev.ivan_belyaev.film_by_id.di.FilmByIdComponent
import dev.ivan_belyaev.film_by_id.presentation.model.FilmsByIdUiModel
import dev.ivan_belyaev.film_by_id.presentation.model.PostersFilmsUiModel
import dev.ivan_belyaev.film_by_id.presentation.posters.PostersListAdapter
import dev.ivan_belyaev.film_by_id.presentation.posters.PostersModel
import dev.ivan_belyaev.filmbyid.databinding.FragmentFilmByIdBinding
import javax.inject.Inject

class FilmByIdFragment :
    BaseFragment<FilmByIdViewModel, FragmentFilmByIdBinding>(
        FragmentFilmByIdBinding::inflate
    ) {

    @Inject
    lateinit var appResources: AppResources

    override val viewModel: FilmByIdViewModel by viewModels { viewModelFactory }

    private lateinit var adapter: PostersListAdapter
    private var list: List<PostersModel> = emptyList()

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerView()
        viewModel.state.observe{state -> renderState(state) }
        viewModel.posterState.observe{state -> renderPosterState(state) }
    }

    private fun renderState(state: FilmsByIdUiModel) {
        with(binding) {
            textViewTitle.text = state.name
            textViewDescription.text = state.description
            textViewKpRatingText.text = state.rating.kp.toString()
            textViewImdbRatingText.text = state.rating.imdb.toString()
            textViewFilmCriticsRatingText.text = state.rating.filmCritics.toString()
            textViewRussianFilmCriticsRatingText.text = state.rating.russianFilmCritics.toString()
        }

    }

    private fun renderPosterState(posterState: PostersFilmsUiModel) {
        val arrayList = ArrayList<PostersModel>()
        for (i in 1 .. posterState.docs.lastIndex){
            arrayList.add(
                PostersModel(
                    posterState.docs[i].url,
                    posterState.docs[i].id
                )
            )
        }
        list = arrayList
        adapter.submitList(list)
    }

    fun setRecyclerView(){
        val gridLayoutManager = GridLayoutManager(
            requireContext(), 1, GridLayoutManager.HORIZONTAL, false
        )
        binding.recyclerViewPosters.layoutManager = gridLayoutManager
        adapter = PostersListAdapter()
        binding.recyclerViewPosters.adapter = adapter
    }

    override fun inject(applicationProvider: ApplicationProvider) {
        FilmByIdComponent.init(applicationProvider)
            .inject(this)
    }
}