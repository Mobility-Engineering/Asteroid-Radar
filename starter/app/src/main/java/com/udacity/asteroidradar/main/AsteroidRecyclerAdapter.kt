package com.udacity.asteroidradar.main

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.udacity.asteroidradar.Asteroid
import com.udacity.asteroidradar.R

class AsteroidRecyclerAdapter : RecyclerView.Adapter<AsteroidRecyclerAdapter.AsteroidViewHolder> {
    var asteroids = listOf<Asteroid>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    private var layoutInflater: LayoutInflater
    private var context: Context

    constructor(context: Context, asteroids: List<Asteroid>) {
        this.asteroids = asteroids
        this.context = context
        layoutInflater = LayoutInflater.from(context)
    }


    override fun getItemCount() = asteroids.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AsteroidViewHolder {

        val view = LayoutInflater.from(parent.context)
        layoutInflater = LayoutInflater.from(parent.context)
        return AsteroidViewHolder(layoutInflater.inflate(R.layout.asteroid_item, parent, false))
    }

    override fun onBindViewHolder(holder:AsteroidViewHolder, position:Int){
        val asteroid = asteroids.get(position)
        holder.title?.setText(asteroid?.codename)
        holder.date?.setText(asteroid?.closeApproachDate)
    }



    inner class AsteroidViewHolder : RecyclerView.ViewHolder {

        var title: TextView?
        var date: TextView?
        var statusIcon: ImageView?

        constructor(itemView: View) : super(itemView) {
            title = itemView.findViewById<TextView>(R.id.title)
            date = itemView.findViewById<TextView>(R.id.date)
            statusIcon = itemView.findViewById<ImageView>(R.id.statusIcon)
        }


    }
}