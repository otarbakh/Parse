package com.example.parse

import com.example.parse.Model.HomeModel
import retrofit2.Response
import retrofit2.http.GET

interface HomesApi {
    @GET("v3/f4864c66-ee04-4e7f-88a2-2fbd912ca5ab")
    suspend fun getHomeModel(): Response<HomeModel>
}