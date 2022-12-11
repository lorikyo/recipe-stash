package com.lorikyo.recipestash.api

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

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

    @GET("api/json/v1/1/search.php")
    suspend fun searchMealByName(@Query("s") s: String): SearchMealsResponse

    @GET("api/json/v1/1/search.php")
    suspend fun listAllMealsByFirstLetter(@Query("f") f: String): SearchMealsResponse

    @GET("api/json/v1/1/lookup.php")
    suspend fun lookupFullMealDetailsById(@Query("i") i: String): SearchMealsResponse

    @GET("api/json/v1/1/random.php")
    suspend fun lookupSingleRandomMeal(): SearchMealsResponse

    @GET("api/json/v1/1/categories.php")
    suspend fun listAllMealCategories(): ListAllMealCategoriesResponse

    @GET("api/json/v1/1/list.php?c=list")
    suspend fun listAllCategories(): ListAllCategoriesResponse

    @GET("api/json/v1/1/list.php?a=list")
    suspend fun listAllAreas(): ListAllAreasResponse

    @GET("api/json/v1/1/list.php?i=list")
    suspend fun listAllIngredients(): ListAllIngredientsResponse

    @GET("api/json/v1/1/filter.php")
    suspend fun filterByMainIngredient(@Query("i") i: String): FilterMealResponse

    @GET("api/json/v1/1/filter.php")
    suspend fun filterByCategory(@Query("c") c: String): FilterMealResponse

    @GET("api/json/v1/1/filter.php")
    suspend fun filterByArea(@Query("a") a: String): FilterMealResponse
}