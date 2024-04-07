package dev.ivan_belyaev.core.navigation

import javax.inject.Provider

typealias MediatorsMap = Map<Class<*>, @JvmSuppressWildcards Provider<Any>>

interface MediatorsProvider {

    fun provideMediatorsMap(): MediatorsMap
}

inline fun <reified T : Any> MediatorsMap.getMediator(): T {
    return getValue(T::class.java).get() as T
}