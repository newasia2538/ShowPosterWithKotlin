package com.example.maii.showmovieposter.Utility

import android.content.Context
import com.example.maii.showmovieposter.Interface.MovieDBService
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Maii on 29/3/2560.
 */

class RetrofitBuilder private constructor() {

    private val mContext: Context?
    private var service: MovieDBService? = null

    init {

        mContext = Contextor.getInstance()!!.getContext()

        val BASE_URL = "https://api.themoviedb.org/3/movie/"

        val gson = GsonBuilder().setDateFormat("yyyy-MM-dd").create()

        val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()

        service = retrofit.create(MovieDBService::class.java)
    }

    fun getService(): MovieDBService {
        return service as MovieDBService
    }

    companion object{
        var instance : RetrofitBuilder? = null

        fun getInst() : RetrofitBuilder {
            if (instance == null)
                instance = RetrofitBuilder()
            return instance as RetrofitBuilder
        }
    }
}