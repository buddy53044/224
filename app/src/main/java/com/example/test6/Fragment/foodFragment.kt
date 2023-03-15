package com.example.test6.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.test6.R
import android.util.Log
import coil.load
import com.example.test6.BuildConfig
import com.example.test6.FoodApiService
import kotlinx.android.synthetic.main.fragment_third.*
import okhttp3.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.example.test6.food.data.req.*
import com.example.test6.food.data.res.*


class ThirdFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lateinit var getDataClass: response_data_class
        var url:String?=null
        var foodId: String
        var measureURI: String=""
        var qualifiers: List<Qualifier>?
        var quantity: Double?

        val GET_Query_data: MutableMap<String, String> = HashMap()
        GET_Query_data["app_id"] = BuildConfig.food_ID
        GET_Query_data["app_key"] = BuildConfig.food_KEY
        GET_Query_data["nutrition-type"] ="cooking"
        GET_Query_data["ingr"]

//        val POST_Query_data: MutableMap<String, String> = HashMap()
//        POST_Query_data["app_id"] = BuildConfig.food_ID
//        POST_Query_data["app_key"] = BuildConfig.food_KEY




        btn_query.setOnClickListener {
            GET_Query_data["ingr"] =ed.text.toString()
            Log.d("Huang",GET_Query_data.toString())

            val apiService = AppClientManager.client.create(FoodApiService::class.java)
            apiService.GETindex(GET_Query_data).enqueue(object : Callback<response_data_class> {
                override fun onResponse(call: Call<response_data_class>, response: Response<response_data_class>) {
                  val list = response.body()
                    if (list != null) {
                        getDataClass= list
                    }
                    tv.text =list!!.hints.get(0).toString()


//                    Log.d("foodId", getDataClass.hints.get(0).food.foodId)
//                    Log.d("getDataClass", getDataClass.hints.get(0).toString())



                    url= list!!.hints.get(0).food.image
                    image.load(url)

                }

                override fun onFailure(call: retrofit2.Call<response_data_class>, t: Throwable) {
                }
            })

//            Log.d("foodId", getDataClass.hints.get(0).food.foodId)
//            Log.d("measureURI",  getDataClass.hints.get(0).measures.get(0).uri)
//            Log.d("qualifiers", listOf(getDataClass.hints.get(0).measures.get(0).qualified.get(0).qualifiers.get(0).uri,
//                getDataClass.hints.get(0).measures.get(0).qualified.get(0).qualifiers.get(0).label).toString()
//            )
//            Log.d("quantity",
//                getDataClass.hints.get(0).food.servingSizes.get(0).quantity.toString()
//            )








        }


//        val sendMessages: MutableList<Ingredient> = mutableListOf()
//        Log.i("s", getDataClass.toString())
        btn_post.setOnClickListener{

//            val reqMessage =Ingredient(foodId = getDataClass.hints.get(0).food.foodId,
//            measureURI = getDataClass.hints.get(0).measures.get(0).uri,
//            qualifiers = listOf(getDataClass.hints.get(0).measures.get(0).qualified.get(0).qualifiers.get(0).uri,
//                getDataClass.hints.get(0).measures.get(0).qualified.get(0).qualifiers.get(0).label),
//            quantity = getDataClass.hints.get(0).food.servingSizes.get(0).quantity)
//            sendMessages.add(reqMessage)
//            Log.d("getDataClass", getDataClass.hints.get(0).toString())

//
//            var data=Ingredient(
//            foodId="food_bwy4zdhatwyt7bazilhn6acizh5b",
//            measureURI="http://www.edamam.com/ontologies/edamam.owl#Measure_serving",
//            quantity= 17.0,
//            qualifiers=null
//            )
            val apiService = AppClientManager.client.create(FoodApiService::class.java)
            apiService.POSTindex(
                foodId="food_bwy4zdhatwyt7bazilhn6acizh5b",
                measureURI="http://www.edamam.com/ontologies/edamam.owl#Measure_serving",
                quantity= 17.0,
                qualifiers=null



//            foodId = getDataClass.hints.get(0).food.foodId,
//                measureURI = getDataClass.hints.get(0).measures.get(0).uri,
//                qualifiers = listOf(getDataClass.hints.get(0).measures.get(0).qualified.get(0).qualifiers.get(0).uri,
//                    getDataClass.hints.get(0).measures.get(0).qualified.get(0).qualifiers.get(0).label),
//                quantity = getDataClass.hints.get(0).food.servingSizes.get(0).quantity
//                quantity=null

            ).enqueue(object : Callback<request_data_class> {
                override fun onResponse(call: Call<request_data_class>, response: Response<request_data_class>) {
                    val te = response.body()
//                    list?.let {
//                        for (p2 in it) {
//                            sb.append(p.body)
//                            sb.append("\n")
//                            sb.append("---------------------\n")
//                        }
//                    }get req json
//                    post req res-??
                    Log. i("ttt",te.toString())

                }
                override fun onFailure(call: retrofit2.Call<request_data_class>, t: Throwable) {
                    Log.i ("ttt","error")
                }
            })


        }

    }



}


class AppClientManager private constructor() {
    val baseURL="https://api.edamam.com"


    private val retrofit: Retrofit
    private val okHttpClient = OkHttpClient()

    init {
        retrofit = Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    companion object {
        private val manager = AppClientManager()
        val client: Retrofit
            get() = manager.retrofit
    }
}