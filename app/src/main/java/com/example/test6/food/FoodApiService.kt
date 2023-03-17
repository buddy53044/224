package com.example.test6

import com.example.test6.food.data.foodDatabase_data.*

import com.example.test6.food.data.res.foodData_get_Response_data_class
import com.example.test6.food.data.res.foodData_post_Request_data_class
import retrofit2.Call
import retrofit2.http.*


interface FoodApiService {
    //    @GET("https://api.edamam.com/api/food-database/v2/parser?app_id=ed8896ab&app_key=35488a643aa2e7b7691d085b31de8587&ingr=1%20whole%20chicken&nutrition-type=cooking\n")
    @GET("api/food-database/v2/parser")
    fun GETindex(
        @QueryMap GET_Query_data: Map<String, String,>
    ): Call<foodData_get_Response_data_class>


//    @Headers("Content-Type: application/json")
//    @POST("/api/food-database/v2/nutrients")
    @POST("api/food-database/v2/nutrients?app_id=${BuildConfig.food_ID}&app_key=${BuildConfig.food_KEY}")
    fun POSTindex(
//        @Body body: MutableList<Ingredient>,
//        @QueryMap POST_Query_data: Map<String, String,>,

        @Query("foodId") foodId: String,
        @Query("measureURI") measureURI: String,
        @Query("qualifiers") qualifiers: List<String>?,
        @Query("quantity") quantity: Double?
//        @Query("ingredients")
//        @Field("foodId")  food: Food
    ):Call<foodData_post_Request_data_class>


}



