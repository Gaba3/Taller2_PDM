package com.pdmtaller2.c00103923_GabrielBatres.ui.ui.navigation

import kotlinx.serialization.Serializable

@Serializable
object SearchScreen {
    const val route = "search_screen"
    fun createRoute(restaurantId: String): String {
        return "$route/$restaurantId"
    }
}

@Serializable
object OrderScreen {
    const val route = "orders_screen"
}

@Serializable
object HomeScreen {
    const val route = "home_screen"
}
