// Archivo: BottomBar.kt
package com.pdmtaller2.c00103923_GabrielBatres.ui.components

import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart

@Composable
fun BottomBar(navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    NavigationBar {
        NavigationBarItem(
            selected = currentRoute == "home_screen",
            onClick = { navController.navigate("home_screen") },
            icon = { Icon(imageVector = Icons.Filled.Home, contentDescription = "Inicio") },
            label = { Text("Inicio") }
        )
        NavigationBarItem(
            selected = currentRoute == "search_screen",
            onClick = { navController.navigate("search_screen") },
            icon = { Icon(imageVector = Icons.Filled.Search, contentDescription = "Buscar") },
            label = { Text("Buscar") }
        )
        NavigationBarItem(
            selected = currentRoute == "orders_screen",
            onClick = { navController.navigate("orders_screen") },
            icon = { Icon(imageVector = Icons.Filled.ShoppingCart, contentDescription = "Órdenes") },
            label = { Text("Órdenes") }
        )
    }
}
