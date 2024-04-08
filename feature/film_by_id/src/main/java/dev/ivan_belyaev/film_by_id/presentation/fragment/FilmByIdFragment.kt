package dev.ivan_belyaev.film_by_id.presentation.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import dev.ivan_belyaev.core.app.ApplicationProvider
import dev.ivan_belyaev.core.base.BaseFragment
import dev.ivan_belyaev.core.resources.AppResources
import dev.ivan_belyaev.film_by_id.di.FilmByIdComponent
import dev.ivan_belyaev.film_by_id.presentation.viewmodel.FilmByIdViewModel
import dev.ivan_belyaev.filmbyid.databinding.FragmentFilmByIdBinding
import javax.inject.Inject

class FilmByIdFragment :
    BaseFragment<FilmByIdViewModel, FragmentFilmByIdBinding>(
        FragmentFilmByIdBinding::inflate
    ) {

    @Inject
    lateinit var appResources: AppResources

    override val viewModel: FilmByIdViewModel by viewModels { viewModelFactory }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.testGetRequest()
        /*viewModel.viewState.observe { state -> renderState(state) }*/
    }

    private fun renderState(/*state: FilmByIdViewState*/) {
        with(binding) {

        }
    }

    override fun inject(applicationProvider: ApplicationProvider) {
        FilmByIdComponent.init(applicationProvider)
            .inject(this)
    }
}