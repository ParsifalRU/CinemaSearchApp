package dev.ivan_belyaev.core.base

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.ivan_belyaev.core.navigation.NavData
import dev.ivan_belyaev.core.navigation.NavEvent
import dev.ivan_belyaev.core.navigation.NavigationCommand
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

abstract class BaseViewModel() : ViewModel() {

    private val coroutineExceptionHandler =
        CoroutineExceptionHandler { coroutineContext, throwable ->
            onCoroutineError(coroutineContext, throwable)
        }

    protected open fun onCoroutineError(coroutineContext: CoroutineContext, throwable: Throwable) {
        Log.e(
            BaseViewModel::class.simpleName,
            "Exception in coroutine:\n${throwable.stackTraceToString()}"
        )
    }

    protected fun launch(
        extraContext: CoroutineContext = EmptyCoroutineContext,
        block: suspend CoroutineScope.() -> Unit
    ) {
        viewModelScope.launch(coroutineExceptionHandler + extraContext) { block() }
    }

    private val _navigation = MutableSharedFlow<NavEvent<NavigationCommand>>()
    val navigation: MutableSharedFlow<NavEvent<NavigationCommand>> get() = _navigation

    fun navigate(navData: NavData) {
        viewModelScope.launch {
            _navigation.emit(NavEvent(NavigationCommand.ToDirection(navData)))
        }
    }

    fun navigate(action: () -> NavData) {
        val navData = action.invoke()
        viewModelScope.launch {
            _navigation.emit(NavEvent(NavigationCommand.ToDirection(navData)))
        }
    }

    fun navigateBack() {
        viewModelScope.launch {
            _navigation.emit(NavEvent(NavigationCommand.Back))
        }
    }
}