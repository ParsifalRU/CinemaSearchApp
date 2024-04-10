package dev.ivan_belyaev.core.base

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
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
}