package com.example.nasacollection.data

import com.example.nasacollection.models.NasaData
import com.example.nasacollection.utils.Constants.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET

interface NasaApi {
    @GET(API_KEY)
    suspend fun getData(): Response<NasaData>
}