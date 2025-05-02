package com.pdmtaller2.c00103923_GabrielBatres.data

import com.pdmtaller2.c00103923_GabrielBatres.R

enum class FoodCategory(val displayName: String) {
    FAST_FOOD( "Comida Rápida"),
    MEXICAN( "Comida Mexicana"),
    ITALIAN("Comida Italiana"),
    ASIAN("Comida Asiática"),
    HEALTHY("Comida Saludable"),
    DESSERTS("Postres y Dulces"),
    DRINKS("Bebidas")
}

fun groupRestaurantsByCategory(restaurants: List<Restaurant>): Map<FoodCategory, List<Restaurant>> {
    return restaurants.groupBy { it.categories }
}

data class Dish(
    val id: Int,
    val name: String,
    val description: String,
    val imageRes: Int
)

data class Restaurant(
    val id: Int,
    val name: String,
    val description: String,
    val imageRes: Int,
    val categories: FoodCategory,
    val menu: List<Dish>
)

val restaurants = listOf(
    Restaurant(
        id = 1,
        name = "McDonald's",
        description = "Fast Food Burguer Restaurant",
        imageRes = R.drawable.mcdonals_logo,
        categories = FoodCategory.FAST_FOOD,
        menu = listOf(
            Dish(id = 1,
                name = "Big Mac",
                description = "Double burguer",
                imageRes = R.drawable.big_mac
            ),
            Dish(id = 2,
                name = "Happy meal",
                description = "Kids meal",
                imageRes = R.drawable.happy_meal
            )
        )
    ),
    Restaurant(
        id = 2,
        name = "Little Caesars",
        description = "Fast Food Pizza Restaurant",
        imageRes = R.drawable.little_caesar,
        categories = FoodCategory.FAST_FOOD,
        menu = listOf(
            Dish(id = 3,
                name = "Peperoni Pizza",
                description = "Extra large peperoni pizza",
                imageRes = R.drawable.pepperoni_pizzza
            ),
            Dish(id = 4,
                name = "Cheese Pizza",
                description = "Extra large cheese pizza",
                imageRes = R.drawable.cheese_pizza
            )
        )
    ),
    Restaurant(
        id = 3,
        name = "LacaLaca",
        description = "Mexican Food Restaurant",
        imageRes = R.drawable.lacalaca_logo,
        categories = FoodCategory.MEXICAN,
        menu = listOf(
            Dish(id = 5,
                name = "Tacos order",
                description = "3 tacos al pastor",
                imageRes = R.drawable.tacos_pastor
            ),
            Dish(id = 6,
                name = "Quesadilla",
                description = "3 cheese and mushroom quesadillas",
                imageRes = R.drawable.quesadilla
            )
        )
    ),
    Restaurant(
        id = 4,
        name = "Taco Bell",
        description = "Fast Food Mexican Restaurant",
        imageRes = R.drawable.taco_bell_logo,
        categories = FoodCategory.MEXICAN,
        menu = listOf(
            Dish(id = 7,
                name = "Crunchwrap",
                description = "1 crunchwrap with beef",
                imageRes = R.drawable.crunch_wrap
            ),
            Dish(id = 8,
                name = "Crunchy Taco",
                description = "3 crunchy tacos",
                imageRes = R.drawable.crunch_taco
            )
        )
    ),
    Restaurant(
        id = 5,
        name = "Koi",
        description = "Asian Food Restaurant",
        imageRes = R.drawable.koi_logo,
        categories = FoodCategory.ASIAN,
        menu = listOf(
            Dish(id = 9,
                name = "Sushi rolls",
                description = "10 sushi rolls",
                imageRes = R.drawable.sushi_roll
            ),
            Dish(id = 10,
                name = "Salmon sashimi",
                description = "Sashimi with salmon",
                imageRes = R.drawable.sashimi
            )
        )
    ),
    Restaurant(
        id = 6,
        name = "Don Li",
        description = "Asian Food Restaurant",
        imageRes = R.drawable.don_li_logo,
        categories = FoodCategory.ASIAN,
        menu = listOf(
            Dish(id = 11,
                name = "Spicy ramen",
                description = "Bowl of spicy ramen",
                imageRes = R.drawable.ramen
            ),
            Dish(id = 12,
                name = "Kung pao chicken",
                description = "Breaded chicken with peanuts",
                imageRes = R.drawable.kung_pao
            )
        )
    ),
    Restaurant(
        id = 7,
        name = "Go Green",
        description = "Healthy Food Restaurant",
        imageRes = R.drawable.go_green_logo,
        categories = FoodCategory.HEALTHY,
        menu = listOf(
            Dish(id = 13,
                name = "Caesar salad",
                description = "Bowl of caesar salad",
                imageRes = R.drawable.caesar_salad
            ),
            Dish(id = 14,
                name = "Wrap",
                description = "Vegetable wrap",
                imageRes = R.drawable.healthy_wrap
            )
        )
    ),
    Restaurant(
        id = 8,
        name = "The Green House",
        description = "Healthy Food Restaurant",
        imageRes = R.drawable.the_green_house_logo,
        categories = FoodCategory.HEALTHY,
        menu = listOf(
            Dish(id = 15,
                name = "Smoked salmon salad",
                description = "Bowl of smoked salmon salad",
                imageRes = R.drawable.salmon_salad
            ),
            Dish(id = 16,
                name = "Chicken burrito",
                description = "Burrito with chicken filet",
                imageRes = R.drawable.burrito_chicken
            )
        )
    ),
    Restaurant(
        id = 9,
        name = "Ocha Bobba",
        description = "Smoothie and dessert restaurant",
        imageRes = R.drawable.ocha_bobba_logo,
        categories = FoodCategory.DRINKS,
        menu = listOf(
            Dish(id = 17,
                name = "Classic milk tea",
                description = "Black tea with milk",
                imageRes = R.drawable.milk_tea
            ),
            Dish(id = 18,
                name = "Matcha latte",
                description = "Match latte with milk",
                imageRes = R.drawable.matcha_latte
            )
        )
    ),
    Restaurant(
        id = 10,
        name = "La Bodega Italiana",
        description = "Italian Food Restaurant",
        imageRes = R.drawable.la_bodega_logo,
        categories = FoodCategory.ITALIAN,
        menu = listOf(
            Dish(id = 19,
                name = "Lagsana",
                description = "Family size lagsana",
                imageRes = R.drawable.lasagna
            ),
            Dish(id = 20,
                name = "Alfredo pasta",
                description = "Pasta with alfredo sauce",
                imageRes = R.drawable.alfredo_pasta
            )
        )
    ),
    Restaurant(
        id = 11,
        name = "Al Pommodoro",
        description = "Italian Food Restaurant",
        imageRes = R.drawable.al_pommodoro_logo,
        categories = FoodCategory.ITALIAN,
        menu = listOf(
            Dish(id = 21,
                name = "Risotto Tartufato",
                description = "Risotto with truffle",
                imageRes = R.drawable.risotto
            ),
            Dish(id = 22,
                name = "Ravioli Amalfi",
                description = "Ravioli with seafood",
                imageRes = R.drawable.ravioli
            )
        )
    ),
    Restaurant(
        id = 12,
        name = "Beer Station",
        description = "Bar and Restaurant",
        imageRes = R.drawable.beer_station_logo,
        categories = FoodCategory.DRINKS,
        menu = listOf(
            Dish(id = 23,
                name = "Pilsener",
                description = "National beer",
                imageRes = R.drawable.pilsener
            ),
            Dish(id = 24,
                name = "Guinness",
                description = "International beer",
                imageRes = R.drawable.guiness
            )
        )
    ),
    Restaurant(
        id = 13,
        name = "Andián",
        description = "Dessert Restaurant",
        imageRes = R.drawable.andian_logo,
        categories = FoodCategory.DESSERTS,
        menu = listOf(
            Dish(id = 25,
                name = "Forest cake",
                description = "Tart with berries",
                imageRes = R.drawable.forest_tart
            ),
            Dish(id = 26,
                name = "Crème brûlée",
                description = "Caramelized custard",
                imageRes = R.drawable.creme_brule
            )
        )
    ),
    Restaurant(
        id = 14,
        name = "Llao Llao",
        description = "Sweet amd healthy dessert restaurant",
        imageRes = R.drawable.llao_llao_logo,
        categories = FoodCategory.DESSERTS,
        menu = listOf(
            Dish(id = 27,
                name = "Small yogurt",
                description = "Small yogurt with 1 topping",
                imageRes = R.drawable.small_yogurt
            ),
            Dish(id = 28,
                name = "Frappé mocha",
                description = "Coffee frappé with chocolate",
                imageRes = R.drawable.frape_mocha
            )
        )
    )
)


