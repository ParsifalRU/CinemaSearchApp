package dev.ivan_belyaev.all_films_api.presentation.viewmodel

import dev.ivan_belyaev.core.base.BaseViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class AllFilmsViewModel  @Inject constructor() : BaseViewModel() {

    fun testGetRequest(){
        CoroutineScope(Dispatchers.IO).launch {

        }
    }

}