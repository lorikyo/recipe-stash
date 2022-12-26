package com.lorikyo.recipestash.api

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface MealDBService {
    companion object {
        private const val BASE_URL = "https://www.themealdb.com/"

        fun create(): MealDBService {
            val logger = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()

            val gson = GsonBuilder()
                .setLenient()
                .create()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
                .create(MealDBService::class.java)
        }
    }

    @GET("api/json/v1/1/random.php")
    suspend fun lookupSingleRandomMeal(): SearchMealsResponse

    @GET("api/json/v1/1/list.php?c=list")
    suspend fun listAllCategories(): ListAllCategoriesResponse

    @GET("api/json/v1/1/list.php?a=list")
    suspend fun listAllAreas(): ListAllAreasResponse

}