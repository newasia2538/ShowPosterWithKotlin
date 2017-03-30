package com.example.maii.showmovieposter.Interface

import com.example.maii.showmovieposter.Models.Movies
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


/**
 * Created by Maii on 29/3/2560.
 */
interface MovieDBService {


    @GET("popular")
    fun getPopularMovie(@Query("api_key") id: String): Call<Movies>

    @GET("top_rated")
    fun getTopRatedMovie(@Query("api_key") id: String): Call<Movies>
}