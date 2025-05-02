package com.pdmtaller2.c00103923_GabrielBatres.ui.ui.Screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.pdmtaller2.c00103923_GabrielBatres.data.FoodCategory
import com.pdmtaller2.c00103923_GabrielBatres.data.Restaurant
import com.pdmtaller2.c00103923_GabrielBatres.data.groupRestaurantsByCategory
import com.pdmtaller2.c00103923_GabrielBatres.ui.components.RestaurantCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    restaurants: List<Restaurant>,
    onRestaurantSelected: (Restaurant) -> Unit,
    onOrdersScreen: () -> Unit,
    onSearchScreen: () -> Unit
) {
    val groupedRestaurants: Map<FoodCategory, List<Restaurant>> =
        groupRestaurantsByCategory(restaurants)

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Food Spot"
                    )
                }
            )
        },
        bottomBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(text = "Listado")
                Text(text = "Busqueda", modifier = Modifier.clickable { onSearchScreen() })
                Text(text = "Mis Ordenes", modifier = Modifier.clickable { onOrdersScreen() })
            }
        }
    ) { innerPadding ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            groupedRestaurants.forEach { (category, restaurantList) ->
                item {
                    Text(
                        text = category.displayName,
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                    )
                }
                item {
                    LazyRow(
                        modifier = Modifier.fillMaxWidth(),
                        contentPadding = PaddingValues(start = 16.dp, end = 16.dp)
                    ) {
                        items(restaurantList) { restaurant ->
                            RestaurantCard(
                                restaurant = restaurant,
                                onClick = { onRestaurantSelected(restaurant) }
                            )
                        }
                    }
                }

            }
        }
    }
}
