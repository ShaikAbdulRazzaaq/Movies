package com.assignment.movies

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class RecyclerAdapter(context: Context,list: List<Movies>) : RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {
    var list: List<Movies>? = null
    var context: Context? = null

    init{
        this.list = list
        this.context = context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(context).inflate(R.layout.movie_list, null, false))
    }

  override  fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val movies = list!![position]
        holder.title.text = movies.title
        holder.rating.text = movies.vote_average
        holder.overView.text = movies.overview
        holder.date.text = movies.release_date
        Picasso.get().load(movies.poster_path).centerCrop().into(holder.imageOfPoster)
    }

    override fun getItemCount(): Int {
        return list!!.size
    }

    class MyViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var title: TextView = itemView.findViewById(R.id.TitleOfMovie)
        var date: TextView = itemView.findViewById(R.id.dateOfMovie)
        var overView: TextView = itemView.findViewById(R.id.OverView)
        var rating: TextView = itemView.findViewById(R.id.ratingPercent)
        var imageOfPoster: ImageView = itemView.findViewById(R.id.image)
    }

}