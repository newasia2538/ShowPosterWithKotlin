package com.example.maii.showmovieposter.Adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.example.maii.showmovieposter.Interface.ViewType

interface DelegateAdapter {

    fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder

    fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType)
}
