package com.example.maii.showmovieposter

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.example.maii.showmovieposter.Adapter.CustomAdapter
import com.example.maii.showmovieposter.Models.Constant
import com.example.maii.showmovieposter.Models.Movies
import com.example.maii.showmovieposter.Utility.RetrofitBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var mRecyclerView = findViewById(R.id.recycler_view) as RecyclerView

        mRecyclerView.setHasFixedSize(true)

        var mLayoutManager = GridLayoutManager(this, 2)
        mRecyclerView.layoutManager = mLayoutManager

        var mAdapter = CustomAdapter(this, initMovies())
        Log.d("afterInit", "working")
        mRecyclerView.adapter = mAdapter
    }

    fun initMovies(): List<Movies.ResultsBean>? {

        Log.i("onInit", "working")

        var dataSet: List<Movies.ResultsBean>? = null

        var service = RetrofitBuilder.getInst()
                .getService()
                .getPopularMovie(Constant.id)
        service.enqueue(object : Callback<Movies> {

            override fun onResponse(call: Call<Movies>?, response: Response<Movies>?) {
                if (response != null) {
                    if(response.isSuccessful)
                        dataSet = response?.body()?.results
                    else Log.e("onResponse",response.message())
                }

                Log.d("onResponse", dataSet.toString())
            }

            override fun onFailure(call: Call<Movies>?, t: Throwable?) {
                Log.e("onFailure", t?.message)
            }
        }

        )

        return dataSet
    }


}
