package com.example.nasacollection.di

import com.example.nasacollection.data.NasaApi
import com.example.nasacollection.utils.Constants.Companion.API_KEY
import com.example.nasacollection.utils.Constants.Companion.BASE_URL
import com.example.nasacollection.utils.TodayDate
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {
    @Singleton
    @Provides
    fun ProvideRetroFit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideUserApi(retrofit: Retrofit): NasaApi{
        return retrofit.create(NasaApi::class.java)
    }


}