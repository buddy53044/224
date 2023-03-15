package com.example.test6.food.data.res


data class post_response(
    val calories: Int,
    val cautions: List<Any>,
    val dietLabels: List<Any>,
    val healthLabels: List<Any>,
    val ingredients: List<Ingredient>,
    val totalDaily: TotalDaily,
    val totalNutrients: TotalNutrients,
    val totalWeight: Int,
    val uri: String
)

class Ingredient

class TotalDaily

class TotalNutrients