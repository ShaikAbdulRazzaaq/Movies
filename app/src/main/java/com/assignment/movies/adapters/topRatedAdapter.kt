package com.assignment.movies.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.assignment.movies.R
import com.assignment.movies.dataTopRated.MoviesTopRated
import com.squareup.picasso.Picasso

open class topRatedAdapter(context: Context) :
    RecyclerView.Adapter<topRatedAdapter.Holder>() {
    private var context: Context? = null
    private var list: List<MoviesTopRated>? = null
    init {
        this.context=context
    }

    fun settopRated(list: List<MoviesTopRated>){
        this.list = list
        notifyDataSetChanged()
    }

    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView = itemView.findViewById(R.id.TitleOfMovie)
        var date: TextView = itemView.findViewById(R.id.dateOfMovie)
        var rating: TextView = itemView.findViewById(R.id.ratingPercent)
        var overView: TextView = itemView.findViewById(R.id.OverView)
        var image: ImageView = itemView.findViewById(R.id.image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(
            LayoutInflater.from(context).inflate(R.layout.movie_list, null, false)
        )
    }

    override fun getItemCount(): Int {
        return list?.size!!
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val topRated = list!![position]
        holder.title.text = topRated.results[position].title
        holder.rating.text = topRated.results[position].voteAverage.toString()
        holder.overView.text = topRated.results[position].overview
        holder.date.text = topRated.results[position].releaseDate
        Picasso.get().load("https://image.tmdb.org/t/p/w342"+topRated.results[position].posterPath).centerCrop().into(holder.image)
    }
}