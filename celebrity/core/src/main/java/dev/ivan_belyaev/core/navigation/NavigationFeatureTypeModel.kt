package dev.ivan_belyaev.core.navigation

import java.io.Serializable

sealed class NavigationFeatureTypeModel: Serializable {

    object NavigationPinCodeType : NavigationFeatureTypeModel()
    object NavigationPasswordType : NavigationFeatureTypeModel()
}