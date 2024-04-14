package dev.ivan_belyaev.all_films_api.presentation.fragment

import android.annotation.SuppressLint
import android.os.Bundle
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
import dev.ivan_belyaev.coreui.listeners.setDebouncedClickListener
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
        }
    }

    @SuppressLint("SetTextI18n")
    private fun renderAllNamesState(namesState: FilmByNameUiModel) {
        binding.currentPageTextView.text = " .. ${namesState.page} .. "
        binding.endPageTextView.text = namesState.pages.toString()
        val arrayList = ArrayList<AllFilmsModel>()
        for (i in 0..namesState.docs.lastIndex) {
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
        var actualSearchText = ""
        binding.searchView.setDebouncedQueryTextListener(
            onQuerySubmitAction = { query ->
                viewModel.updateFilmsList(query.toString(), 1)
            },
            onQueryChangeAction = { newText ->
                if (newText != null) {
                    actualSearchText = newText
                }
                viewModel.updateFilmsList(newText.toString(), 1)
            }
        )
        binding.filterTextView.setDebouncedClickListener {
            binding.expandableFilterLayout.root.visibility = View.VISIBLE
            binding.searchView.visibility = View.GONE
        }
        binding.expandableFilterLayout.closeButton.setOnClickListener {
            binding.expandableFilterLayout.root.visibility = View.GONE
            binding.searchView.visibility = View.VISIBLE
        }
        when (binding.searchView.visibility) {
            View.VISIBLE -> {
                binding.nextPageTextView.setDebouncedClickListener {
                    viewModel.nextPageFilmList(actualSearchText)
                }
                binding.previousPageTextView.setDebouncedClickListener {
                    viewModel.previousPageFilmList(actualSearchText)
                }
            }

            View.GONE -> {
                binding.nextPageTextView.setDebouncedClickListener {
                    viewModel.nextPageWithFilterFilms(
                        countriesName = getFilterTest()[1]?.replace(" ", "")?.split(", ")
                            ?.toTypedArray(),
                        premiereCinema = getFilterTest()[2]?.replace(" ", "")?.split(", ")
                            ?.map { it.trim() }?.toTypedArray(),
                        ageRating = getFilterTest()[0]?.replace(" ", "")?.split(", ")
                            ?.map { it.trim() }?.toTypedArray()
                    )
                }
                binding.previousPageTextView.setDebouncedClickListener {
                    viewModel.previousPageWithFilterFilms(
                        countriesName = getFilterTest()[1]?.replace(" ", "")?.split(", ")
                            ?.toTypedArray(),
                        premiereCinema = getFilterTest()[2]?.replace(" ", "")?.split(", ")
                            ?.map { it.trim() }?.toTypedArray(),
                        ageRating = getFilterTest()[0]?.replace(" ", "")?.split(", ")
                            ?.map { it.trim() }?.toTypedArray()
                    )
                }
            }
            View.INVISIBLE -> {}
        }

        binding.expandableFilterLayout.applyButton.setDebouncedClickListener {
            viewModel.updateFilmsWithFiltersList(
                countriesName = getFilterTest()[1]?.replace(" ", "")?.split(", ")?.toTypedArray(),
                premiereCinema = getFilterTest()[2]?.replace(" ", "")?.split(", ")
                    ?.map { it.trim() }?.toTypedArray(),
                ageRating = getFilterTest()[0]?.replace(" ", "")?.split(", ")?.map { it.trim() }
                    ?.toTypedArray()
            )
        }
    }

    private fun getFilterTest(): Array<String?> {
        val array = arrayListOf<String?>()
        if (binding.expandableFilterLayout.ageEditText.text.toString() != "") {
            array.add(binding.expandableFilterLayout.ageEditText.text.toString())
        } else array.add(null)
        if (binding.expandableFilterLayout.countryEditText.text.toString() != "") {
            array.add(binding.expandableFilterLayout.countryEditText.text.toString())
        } else array.add(null)
        if (binding.expandableFilterLayout.endYearEditText.text.toString() != "") {
            array.add(binding.expandableFilterLayout.endYearEditText.text.toString())
        } else array.add(null)
        return array.toTypedArray()
    }

    private fun setRecyclerView() {
        val linearLayoutManager = LinearLayoutManager(
            requireContext(), LinearLayoutManager.VERTICAL, false
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