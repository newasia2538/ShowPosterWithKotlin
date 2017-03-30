package com.example.maii.showmovieposter.Utility

import android.content.Context

/**
 * Created by Maii on 29/3/2560.
 */
object Contextor {


    private var instance: Contextor? = null

    fun getInstance(): Contextor? {
        if (instance == null)
            instance = Contextor
        return instance
    }


    private var mContext: Context? = null


    fun init(context: Context) {
        mContext = context
    }

    fun getContext(): Context? {
        return mContext
    }
}