package com.arash.altafi.menus.slider.slider7

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.arash.altafi.menus.R
import com.bumptech.glide.Glide

class TrendingAdapter : RecyclerView.Adapter<TrendingAdapter.Holder>() {

    private lateinit var movies: List<Photo7>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_trending, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val movie= movies[position]

        Glide.with(holder.itemView.context)
            .load(movie.url)
            .into(holder.imageMovieTrend)

        holder.imageMovieTrend.setOnClickListener {
            Toast.makeText(holder.itemView.context, movie.title, Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int = movies.size

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageMovieTrend: ImageView = itemView.findViewById(R.id.imageMovieTrend)
    }

    fun setTrends(movies: List<Photo7>) {
        this.movies = movies
        notifyDataSetChanged()
    }
}