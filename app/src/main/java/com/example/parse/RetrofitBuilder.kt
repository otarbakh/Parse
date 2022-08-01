package com.example.parse

import com.example.parse.Model.File
import com.example.parse.Model.MYmodels
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


object RetrofitBuilder {

    private const val BASE_URL = "https://run.mocky.io/v3/"

    val vehicleBuilder by lazy{
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }
    fun getVehicleService () = vehicleBuilder.create(VehicleApi::class.java)
}

interface VehicleApi {
    @GET("3588163c-a9c8-488c-af9a-534b392e7128")
    suspend fun getVehicleModel(): Response<File>
}