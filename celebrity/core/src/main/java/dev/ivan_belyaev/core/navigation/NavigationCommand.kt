package dev.ivan_belyaev.core.navigation

sealed class NavigationCommand {

    data class ToDirection(val navData: NavData) : NavigationCommand()

    object Back : NavigationCommand()
}