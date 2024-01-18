package ru.hh.bybit.ui.presentation.common

sealed class Routes(val route: String) {
    data object Splash : Routes("Splash")
    data object Announcements : Routes("Announcements")

}