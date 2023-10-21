package com.example.nasacollection.data

import com.example.nasacollection.models.NasaData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NasaApi {
    @GET("apod")
    suspend fun getData(@Query("api_key") api_key: String): Response<NasaData>
}