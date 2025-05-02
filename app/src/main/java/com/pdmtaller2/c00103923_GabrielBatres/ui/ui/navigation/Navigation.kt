package com.pdmtaller2.c00103923_GabrielBatres.ui.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.pdmtaller2.c00103923_GabrielBatres.ui.ui.Screens.OrderScreen
import com.pdmtaller2.c00103923_GabrielBatres.ui.ui.Screens.HomeScreen
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.pdmtaller2.c00103923_GabrielBatres.data.Restaurant
import com.pdmtaller2.c00103923_GabrielBatres.ui.components.BottomBar
import com.pdmtaller2.c00103923_GabrielBatres.ui.ui.Screens.SearchScreen

@Composable
fun AppNavigation(
    restaurants: List<Restaurant> = com.pdmtaller2.c00103923_GabrielBatres.data.restaurants
) {
    val navController = rememberNavController()
    Scaffold (
        bottomBar = {
            BottomBar(
                navController = navController
            )
        }
    )
    {
        innerPadding ->
        NavHost(
            navController = navController,
            startDestination = HomeScreen.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(HomeScreen.route) {
                HomeScreen(
                    restaurants = restaurants,
                    onRestaurantSelected = { selectedRestaurant: Restaurant ->
                        navController.navigate(SearchScreen.createRoute(selectedRestaurant.id.toString()))
                    },
                    onOrdersScreen = {
                        navController.navigate(OrderScreen.route)
                    },
                    onSearchScreen = {
                        navController.navigate(SearchScreen.route)
                    }
                )
            }
            composable(SearchScreen.route) {
                SearchScreen(
                    showRestaurantDetails = false,
                    restaurant = null,
                    restaurants = restaurants,
                    onRestaurantSelected = { selected ->
                        navController.navigate(SearchScreen.createRoute(selected.id.toString()))
                    }
                )
            }

            composable(
                route = "${SearchScreen.route}/{restaurantId}",
                arguments = listOf(navArgument("restaurantId") { type = NavType.IntType })
            ) { backStackEntry ->
                val restaurantId = backStackEntry.arguments?.getInt("restaurantId")
                val restaurant = restaurants.find { it.id == restaurantId }
                SearchScreen(
                    showRestaurantDetails = true,
                    restaurant = restaurant,
                    restaurants = restaurants
                )
            }

            composable(OrderScreen.route) {
                OrderScreen()
            }
        }
    }
}

