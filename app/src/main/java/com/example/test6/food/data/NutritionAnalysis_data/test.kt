package com.example.test6.food.data.NutritionAnalysis_data

data class test(
    val calories: Int,
    val cautions: List<Any>,
    val dietLabels: List<String>,
    val healthLabels: List<String>,
    val ingredients: List<com.example.test6.food.data.NutritionAnalysis_data.Ingredient>,
    val totalDaily: com.example.test6.food.data.NutritionAnalysis_data.TotalDaily,
    val totalNutrients: com.example.test6.food.data.NutritionAnalysis_data.TotalNutrients,
    val totalNutrientsKCal: com.example.test6.food.data.NutritionAnalysis_data.TotalNutrientsKCal,
    val totalWeight: Double,
    val uri: String
)