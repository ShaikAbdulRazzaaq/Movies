package com.assignment.movies.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.assignment.movies.R
import com.assignment.movies.dataTopRated.Result
import com.squareup.picasso.Picasso

class TopRatedMoviesAdapter(context: Context,listOfTopRated: List<Result>) : RecyclerView.Adapter<TopRatedMoviesAdapter.MyViewHolder>() {
    private var context:Context?=null
    private var listOfTopRated:List<Result>?=null
    init {
     this.context=context
        this.listOfTopRated=listOfTopRated
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       return MyViewHolder(LayoutInflater.from(context).inflate(R.layout.movie_list,null,false))
    }

    override fun getItemCount(): Int {
       return listOfTopRated?.size!!
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val movies = listOfTopRated!![position]
        holder.title.text = movies.title
        holder.rating.text = movies.voteAverage.toString()
        holder.overView.text = movies.overview
        holder.date.text = movies.releaseDate
        Picasso.get().load(movies.posterPath).centerCrop().into(holder.imageOfPoster)
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView = itemView.findViewById(R.id.TitleOfMovie)
        var date: TextView = itemView.findViewById(R.id.dateOfMovie)
        var overView: TextView = itemView.findViewById(R.id.OverView)
        var rating: TextView = itemView.findViewById(R.id.ratingPercent)
        var imageOfPoster: ImageView = itemView.findViewById(R.id.image)
    }
}