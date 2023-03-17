package com.example.test6.food.data.foodDatabase_data

data class Ingredient(
    val foodId: String,
    val measureURI: String,
    val qualifiers: List<String>?,
    val quantity: Double?
)