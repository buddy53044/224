package com.example.test6.food.data.res


import com.example.test6.food.data.req.Hint
import com.example.test6.food.data.req.Links
import com.google.gson.annotations.SerializedName

data class response_data_class(
@SerializedName("_links")
val _links: Links,
@SerializedName("hints")
val hints: List<Hint>,
@SerializedName("List")
val parsed: List<Any>,
@SerializedName("text")
val text: String
)