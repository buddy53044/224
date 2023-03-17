package com.example.test6.food.data.foodDatabase_data



data class Food(
    val brand: String,
    val category: String,
    val categoryLabel: String,
    val foodContentsLabel: String,
    val foodId: String,
    val image: String,
    val knownAs: String,
    val label: String,
    val nutrients: Nutrients,
    val servingSizes: List<ServingSize>,
    val servingsPerContainer: Double
)