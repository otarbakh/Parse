package com.example.parse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory




object RetrofitBuilder {

    private const val BASE_URL = "https://run.mocky.io/"

    val homeBuilder by lazy{
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }
    fun getVehicleService () = homeBuilder.create(HomesApi::class.java)
}
