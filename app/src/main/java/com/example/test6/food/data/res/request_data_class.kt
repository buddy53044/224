package com.example.test6.food.data.res

import com.example.test6.food.data.req.Ingredient
import com.google.gson.annotations.SerializedName

data class request_data_class(
    val ingredients: List<Ingredient>
)