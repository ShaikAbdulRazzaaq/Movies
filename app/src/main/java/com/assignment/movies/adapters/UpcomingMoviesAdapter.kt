package com.assignment.movies.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.assignment.movies.R
import com.assignment.movies.dataUpComing.Result
import com.squareup.picasso.Picasso

class UpcomingMoviesAdapter(context:Context,listOfUpcomingMovies: List<Result>): RecyclerView.Adapter<UpcomingMoviesAdapter.HolderView>() {
    private var context:Context?=null
    private var listOfUpcomingMovies:List<Result>?=null
    init {
        this.context=context
        this.listOfUpcomingMovies=listOfUpcomingMovies
    }
    class HolderView(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView = itemView.findViewById(R.id.TitleOfMovie)
        var date: TextView = itemView.findViewById(R.id.dateOfMovie)
        var overView: TextView = itemView.findViewById(R.id.OverView)
        var rating: TextView = itemView.findViewById(R.id.ratingPercent)
        var imageOfPoster: ImageView = itemView.findViewById(R.id.image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderView {
        return HolderView(LayoutInflater.from(context).inflate(R.layout.movie_list,null,false))
    }

    override fun getItemCount(): Int {
    return listOfUpcomingMovies?.size!!
    }

    override fun onBindViewHolder(holder: HolderView, position: Int) {
        val movies = listOfUpcomingMovies!![position]
        holder.title.text = movies.title
        holder.rating.text = movies.voteAverage.toString()
        holder.overView.text = movies.overview
        holder.date.text = movies.releaseDate
        Picasso.get().load(movies.posterPath).centerCrop().into(holder.imageOfPoster)
    }
}