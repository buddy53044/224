package com.example.test6.food.data.req


data class Measure(
    val label: String,
    val qualified: List<Qualified>,
    val uri: String,
    val weight: Double
)