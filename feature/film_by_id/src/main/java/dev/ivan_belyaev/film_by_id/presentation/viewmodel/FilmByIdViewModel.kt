package dev.ivan_belyaev.film_by_id.presentation.viewmodel

import android.util.Log
import dev.ivan_belyaev.core.base.BaseViewModel
import dev.ivan_belyaev.film_by_id.domain.FilmByIdRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class FilmByIdViewModel @Inject constructor(
    private val filmByIdRepository: FilmByIdRepository
) : BaseViewModel() {

    fun testGetRequest(){
        CoroutineScope(Dispatchers.IO).launch {
            try {
                filmByIdRepository.getAllFilms()
            }catch (e:Exception){
                Log.d("LOGTAG", e.toString())
            }

        }
    }
}