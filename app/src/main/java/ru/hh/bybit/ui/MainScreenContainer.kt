package ru.hh.bybit.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.hh.bybit.ui.presentation.announcement.AnnouncementScreen
import ru.hh.bybit.ui.presentation.common.Routes
import ru.hh.bybit.ui.presentation.splash.SplashScreen

@Composable
fun MainScreenContainer() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.Splash.route) {
        composable(Routes.Splash.route) {
            SplashScreen(navController)
        }
        composable(Routes.Announcements.route) {
            AnnouncementScreen()
        }

    }
}