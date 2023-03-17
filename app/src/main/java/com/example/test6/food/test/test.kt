package com.example.test6.food.test

data class test(
    val calories: Int,
    val cautions: List<Any>,
    val dietLabels: List<String>,
    val healthLabels: List<String>,
    val ingredients: List<Ingredient>,
    val totalDaily: TotalDaily,
    val totalNutrients: TotalNutrients,
    val totalNutrientsKCal: TotalNutrientsKCal,
    val totalWeight: Double,
    val uri: String
)