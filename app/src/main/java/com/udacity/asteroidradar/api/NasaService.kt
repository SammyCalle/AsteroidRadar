package com.udacity.asteroidradar.api

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.udacity.asteroidradar.Constants
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query



interface AsteroidPerDate {
    @GET("/planetary/apod")
    fun getTodayImage(
        @Query("api_key") apiKey: String = Constants.API_KEY
    ): Call<PictureofDay>

    @GET("/neo/rest/v1/feed")
    fun getAsteroids(
        @Query("start_date") start_date : String,
        @Query("end_date") end_date : String,
        @Query("api_key") API_KEY :String = Constants.API_KEY
    ) : Call<String>
}

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

object Network {

    private val retrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(ScalarsConverterFactory.create())
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()

    val asteroids: AsteroidPerDate = retrofit.create(AsteroidPerDate::class.java)
}
