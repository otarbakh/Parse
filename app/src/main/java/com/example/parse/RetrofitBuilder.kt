package com.example.parse


import com.example.parse.Model.HomeModel

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET



object RetrofitBuilder {

    private const val BASE_URL = "https://run.mocky.io/"

    val vehicleBuilder by lazy{
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }
    fun getVehicleService () = vehicleBuilder.create(VehicleApi::class.java)
}

interface VehicleApi {
    @GET("v3/f4864c66-ee04-4e7f-88a2-2fbd912ca5ab")
    suspend fun getVehicleModel(): Response<HomeModel>
}