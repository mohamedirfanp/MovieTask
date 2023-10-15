package com.example.movietask.network

import android.util.Log
import com.example.movietask.constants.BASE_URL
import com.example.movietask.models.SearchResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/")
    suspend fun searchMovies (
        @Query("s") searchItem : String,
        @Query("apiKey") apiKey : String,
        @Query("page") page : Int
    ) : SearchResponse

    companion object {
        var apiService: ApiService? = null
        fun getInstance() : ApiService {
            if (apiService == null) {
                apiService = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(ApiService::class.java)
            }
            return apiService!!
        }
    }
}