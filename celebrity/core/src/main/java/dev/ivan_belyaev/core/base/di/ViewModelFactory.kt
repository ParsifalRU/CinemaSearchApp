package dev.ivan_belyaev.core.base.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

class ViewModelFactory @Inject constructor(
    private val viewModels: MutableMap<Class<out ViewModel>, javax.inject.Provider<ViewModel>>
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val viewModelProvider =
            viewModels[modelClass] ?: error("$modelClass not found")
        return viewModelProvider.get() as T
    }
}