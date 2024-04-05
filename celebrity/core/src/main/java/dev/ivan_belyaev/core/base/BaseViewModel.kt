package dev.ivan_belyaev.core.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.launch

abstract class BaseViewModel(
    /*protected val router: ApplicationRouter*/
) : ViewModel() {

/*    *//**
     * Shortcut for exiting app via [router]
     *//*
    fun exitApp() {
        router.exitApp()
    }

    *//**
     * Shortcut for navigating back on [router]
     *//*
    fun navigateBack() {
        router.back()
    }

    private val coroutineExceptionHandler =
        CoroutineExceptionHandler { coroutineContext, throwable ->
            onCoroutineError(coroutineContext, throwable)
        }

    *//**
     * Called when exception is thrown inside [launch] or it's child coroutine.
     *
     * By default, logs error stack trace.
     *//*
    protected open fun onCoroutineError(coroutineContext: CoroutineContext, throwable: Throwable) {
        Log.e(
            BaseViewModel::class.simpleName,
            "Exception in coroutine:\n${throwable.stackTraceToString()}"
        )
    }

    *//**
     * Shortcut for calling viewModelScope.launch with BaseViewModel's coroutine exception handler.
     *
     * Override [onCoroutineError] to handle exceptions.
     *
     * If a different exception handler is specified in [extraContext], it will be used instead.
     *//*
    protected fun launch(
        extraContext: CoroutineContext = EmptyCoroutineContext,
        block: suspend CoroutineScope.() -> Unit
    ) {
        viewModelScope.launch(coroutineExceptionHandler + extraContext) { block() }
    }

    *//**
     * Maps flow to [Lce] flow, maps data on Lce.Success, and calls [onCoroutineError] on error.
     *
     * Useful for debugging purposes.
     *
     * @see Lce.toLce
     *//*
    fun <T, C> Flow<T>.toLce(
        mapData: suspend (data: T) -> C
    ) = this.toLceDefault(mapData = mapData)
        .onEach { if (it is Lce.Error) onCoroutineError(coroutineContext, it.error) }

    *//**
     * Maps flow to [Lce] flow and calls [onCoroutineError] on error.
     *
     * Useful for debugging purposes.
     *
     * @see Lce.toLce
     *//*
    fun <T> Flow<T>.toLce() = this.toLceDefault()
        .onEach { if (it is Lce.Error) onCoroutineError(coroutineContext, it.error) }*/
}