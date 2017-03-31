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

    var list : List<Movies.ResultsBean>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initMovies()


    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
    }

    fun initMovies() {

        Log.i("onInit", "working")


        var service = RetrofitBuilder.getInst()
                .getService()
                .getPopularMovie(Constant.id)
        service.enqueue(object : Callback<Movies> {

            override fun onResponse(call: Call<Movies>?, response: Response<Movies>?) {
                if (response != null) {
                    if (response.isSuccessful) {
                        list = response.body().results
                        initAdapter(list)
                    }
                    else Log.e("onResponse", response.message())
                }

                Log.d("onResponse", response?.body()?.results.toString())
            }

            override fun onFailure(call: Call<Movies>?, t: Throwable?) {
                Log.e("onFailure", t?.message)
            }
        }

        )


    }

    fun initAdapter(list: List<Movies.ResultsBean>?) {

        var mRecyclerView = findViewById(R.id.recycler_view) as RecyclerView

        mRecyclerView.setHasFixedSize(true)

        var mLayoutManager = GridLayoutManager(this, 2)
        mRecyclerView.layoutManager = mLayoutManager

        var mAdapter = CustomAdapter(this, list)
        mRecyclerView.adapter = mAdapter
    }


}
