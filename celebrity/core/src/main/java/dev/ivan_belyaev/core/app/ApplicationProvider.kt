package dev.ivan_belyaev.core.app

import dev.ivan_belyaev.core.navigation.MediatorsProvider
import dev.ivan_belyaev.core.network.NetworkProvider

interface ApplicationProvider :
    CoreDependenciesProvider,
    NetworkProvider,
    MediatorsProvider