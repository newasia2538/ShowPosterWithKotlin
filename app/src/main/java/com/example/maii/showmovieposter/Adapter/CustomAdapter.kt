package com.example.maii.showmovieposter.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.maii.showmovieposter.Models.Movies
import com.example.maii.showmovieposter.R
import com.squareup.picasso.Picasso


/**
 * Created by Maii on 29/3/2560.
 */
class CustomAdapter constructor(context: Context, dataset: List<Movies.ResultsBean>?) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {


    private var listMovie: List<Movies.ResultsBean>? = dataset
    private var mContext: Context? = context


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var imageView: ImageView? = null

        init {
            imageView = view.findViewById(R.id.image) as ImageView
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.recycler_view_item, parent, false)

        val viewHolder = ViewHolder(view)
        return viewHolder
    }

    override fun getItemCount()= listMovie?.size ?: 0


    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        var movie = listMovie?.get(position) as Movies
        Log.d("test",movie.toString())
        Picasso.with(mContext).load("http://image.tmdb.org/t/p/w342/" + movie.results?.get(position)?.poster_path).into(holder?.imageView)
    }


}