package com.pdmtaller2.c00103923_GabrielBatres

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.pdmtaller2.c00103923_GabrielBatres.data.restaurants
import com.pdmtaller2.c00103923_GabrielBatres.ui.ui.navigation.AppNavigation
import com.pdmtaller2.c00103923_GabrielBatres.ui.ui.theme.FoodSpotByGbatresTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FoodSpotByGbatresTheme {
                AppNavigation(restaurants = restaurants)
            }
        }
    }
}

