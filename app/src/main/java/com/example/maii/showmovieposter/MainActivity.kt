package com.example.maii.showmovieposter

import android.os.Bundle
import android.os.Parcelable
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
import java.util.*


class MainActivity : AppCompatActivity() {

    var list: List<Movies.ResultsBean>? = null
    var count: Int = 0
    var recyclerView: RecyclerView? = null
    var positionIndex: Int = -1
    var state: Parcelable? = null
    var mLayoutManager = GridLayoutManager(this, 2)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_view) as RecyclerView


    }

    override fun onPause() {
        super.onPause()
        positionIndex = mLayoutManager.findFirstCompletelyVisibleItemPosition()
    }

    override fun onResume() {
        super.onResume()

        if (list == null) {
            Log.e("List",list?.size.toString())
            initMovies()
        } else {
            initAdapter(list)
            Log.e("onResume",list?.size.toString())
        }

        Log.e("PositionIndex",positionIndex.toString())

        if (positionIndex != -1) mLayoutManager.scrollToPosition(positionIndex)

    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        if (list?.size != 0 && list != null) {
            outState?.putParcelableArrayList(Constant.LIST, list as ArrayList<out Parcelable>)
        }


        state = mLayoutManager.onSaveInstanceState()
        outState?.putParcelable("State", state)

        outState?.putInt(Constant.POSITION_INDEX, positionIndex)

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        list = savedInstanceState.getParcelableArrayList(Constant.LIST)
        positionIndex = savedInstanceState.getInt(Constant.POSITION_INDEX)
        state = savedInstanceState.getParcelable("State")
    }

    fun initMovies() {

        var service = RetrofitBuilder.getInst()
                .getService()
                .getPopularMovie(Constant.id)
        service.enqueue(object : Callback<Movies> {

            override fun onResponse(call: Call<Movies>?, response: Response<Movies>?) {
                if (response != null) {
                    if (response.isSuccessful) {

                        list = response.body().results
                        initAdapter(list)
                        Log.e("TestAPI", count.toString())
                        count++

                    } else Log.e("onResponse", response.message())
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

        mRecyclerView.layoutManager = mLayoutManager

        var mAdapter = CustomAdapter(this, list)
        mRecyclerView.adapter = mAdapter


    }


}
