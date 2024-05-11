package com.example.tugasjetpackcompose.navigation

sealed class Screen(val route: String, val title: String) {
    data object Home : Screen("home", "OurAnime")
    data object Gallery : Screen("gallery", "My Gallery")
    data object About : Screen("about", "About Me")
    data object Detail : Screen("details", "Detail")
    data object Detail2 : Screen("details2", "Detail2")

    companion object {
        fun fromRoute(route: String?):Screen {

            return when (route) {
                Home.route -> Home
                Gallery.route -> Gallery
                About.route -> About
                Detail.route -> Detail
                Detail2.route -> Detail2

                else -> {
                    if (route?.startsWith("details/") == true) {
                        Detail
                    } else if (route?.startsWith("details2/") == true) {
                        Detail
                    }else {
                        throw IllegalArgumentException("Route $route is not recognized")
                    }
                }
            }
        }
    }
}