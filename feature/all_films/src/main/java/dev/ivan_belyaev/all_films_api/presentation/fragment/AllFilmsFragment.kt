package dev.ivan_belyaev.all_films_api.presentation.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import dev.ivan_belyaev.all_films.databinding.FragmentAllFilmsBinding
import dev.ivan_belyaev.all_films_api.di.AllFilmsComponent
import dev.ivan_belyaev.all_films_api.presentation.viewmodel.AllFilmsViewModel
import dev.ivan_belyaev.core.app.ApplicationProvider
import dev.ivan_belyaev.core.base.BaseFragment
import dev.ivan_belyaev.core.resources.AppResources
import javax.inject.Inject

class AllFilmsFragment :
    BaseFragment<AllFilmsViewModel, FragmentAllFilmsBinding>(
        FragmentAllFilmsBinding::inflate
    ) {

    @Inject
    lateinit var appResources: AppResources

    override val viewModel: AllFilmsViewModel by viewModels { viewModelFactory }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)


        /*viewModel.viewState.observe { state -> renderState(state) }*/
    }

    private fun renderState(/*state: FilmByIdViewState*/) {
        with(binding) {

        }
    }

    override fun inject(applicationProvider: ApplicationProvider) {
        AllFilmsComponent.init(applicationProvider)
            .inject(this)
    }
}