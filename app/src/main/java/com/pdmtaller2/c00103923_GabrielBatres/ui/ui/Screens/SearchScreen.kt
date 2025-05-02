package com.pdmtaller2.c00103923_GabrielBatres.ui.ui.Screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.pdmtaller2.c00103923_GabrielBatres.data.Restaurant
import com.pdmtaller2.c00103923_GabrielBatres.ui.components.RestaurantCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    showRestaurantDetails: Boolean,
    restaurant: Restaurant? = null,
    restaurants: List<Restaurant>,
    onRestaurantSelected: (Restaurant) -> Unit = {}
) {
    var query by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Buscar") })
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(8.dp)
        ) {
            TextField(
                value = query,
                onValueChange = { query = it },
                label = { Text("Buscar") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            if (showRestaurantDetails && restaurant != null) {
                val filteredDishes = restaurant.menu.filter {
                    it.name.contains(query, ignoreCase = true)
                }

                if (filteredDishes.isNotEmpty()) {
                    LazyColumn {
                        items(filteredDishes) { dish ->
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(8.dp)
                                    .semantics { contentDescription = dish.name }
                            ) {
                                Image(
                                    painter = rememberAsyncImagePainter(dish.imageRes),
                                    contentDescription = dish.name,
                                    modifier = Modifier.size(64.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Column {
                                    Text(text = dish.name)
                                    Text(text = dish.description)
                                }
                            }
                        }
                    }
                } else {
                    Text("No se encontraron platos para \"$query\"")
                }

            } else {
                val filteredRestaurants = restaurants.filter {
                    it.name.contains(query, ignoreCase = true)
                }

                if (filteredRestaurants.isNotEmpty()) {
                    LazyColumn {
                        items(filteredRestaurants) { r ->
                            RestaurantCard(
                                restaurant = r,
                                onClick = { onRestaurantSelected(r) }
                            )
                        }
                    }
                } else {
                    Text("No se encontraron restaurantes para \"$query\"")
                }
            }
        }
    }
}



