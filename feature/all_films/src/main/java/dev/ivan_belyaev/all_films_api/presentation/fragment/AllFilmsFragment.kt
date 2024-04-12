package dev.ivan_belyaev.all_films_api.presentation.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dev.ivan_belyaev.all_films.databinding.FragmentAllFilmsBinding
import dev.ivan_belyaev.all_films_api.di.AllFilmsComponent
import dev.ivan_belyaev.all_films_api.presentation.adapter.AllFilmsListAdapter
import dev.ivan_belyaev.all_films_api.presentation.adapter.AllFilmsModel
import dev.ivan_belyaev.all_films_api.presentation.model.FilmByNameUiModel
import dev.ivan_belyaev.all_films_api.presentation.viewmodel.AllFilmsViewModel
import dev.ivan_belyaev.core.app.ApplicationProvider
import dev.ivan_belyaev.core.base.BaseFragment
import dev.ivan_belyaev.coreui.listeners.setDebouncedQueryTextListener

class AllFilmsFragment :
    BaseFragment<AllFilmsViewModel, FragmentAllFilmsBinding>(
        FragmentAllFilmsBinding::inflate
    ) {

    override val viewModel: AllFilmsViewModel by viewModels { viewModelFactory }

    private lateinit var adapter: AllFilmsListAdapter
    private var list: List<AllFilmsModel> = emptyList()

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerView()
        setUpListeners()
        viewModel.state.observe { namesState ->
            renderAllNamesState(namesState)
            Log.d("LOGTAG", namesState.toString())
        }

    }

    private fun renderAllNamesState(namesState: FilmByNameUiModel) {
        val arrayList = ArrayList<AllFilmsModel>()
        for (i in 0 .. namesState.docs.lastIndex){
            arrayList.add(
                AllFilmsModel(
                    namesState.docs[i].internalNames,
                    namesState.docs[i].id
                )
            )
        }
        list = arrayList
        adapter.submitList(list)
    }


     private fun setUpListeners() {
         binding.searchView.setDebouncedQueryTextListener(
             onQuerySubmitAction = { query ->
                 viewModel.updateFilmsList(query.toString())
             },
             onQueryChangeAction = { newText ->
                 viewModel.updateFilmsList(newText.toString())
             }
         )
     }


    private fun setRecyclerView(){
        val linearLayoutManager = LinearLayoutManager(
            requireContext() , LinearLayoutManager.VERTICAL, false
        )
        binding.recyclerViewNames.layoutManager = linearLayoutManager
        adapter = AllFilmsListAdapter(viewModel)
        binding.recyclerViewNames.adapter = adapter
    }


    override fun inject(applicationProvider: ApplicationProvider) {
        AllFilmsComponent.init(applicationProvider)
            .inject(this)
    }
}