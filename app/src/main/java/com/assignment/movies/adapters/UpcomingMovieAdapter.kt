package com.assignment.movies.adapters

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.assignment.movies.DetailedActivity
import com.assignment.movies.R
import com.assignment.movies.data.Result
import com.squareup.picasso.Picasso

class UpcomingMovieAdapter(private val context: Context, private val list: List<Result>) :
    RecyclerView.Adapter<UpcomingMovieAdapter.UpcomingMoviesViewHolder>() {
    private val imageUrl = "https://image.tmdb.org/t/p/w185"

    class UpcomingMoviesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var thumbnailImage: ImageView = itemView.findViewById(R.id.thumbnailImage)
        var thumbnailTextName: TextView = itemView.findViewById(R.id.thumbName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpcomingMoviesViewHolder {
        return UpcomingMoviesViewHolder(
            LayoutInflater.from(context).inflate(R.layout.movies_list, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: UpcomingMoviesViewHolder, position: Int) {
        val r: Result = list[position]
        holder.thumbnailTextName.text = r.title
        Picasso.get().load(imageUrl + r.posterPath).into(holder.thumbnailImage)
        Log.e("Message", r.title)
        holder.itemView.setOnClickListener {
            val index = holder.adapterPosition
            val intent = Intent(context, DetailedActivity::class.java)
            intent.putExtra("Position", index)
            intent.putExtra("Object",r)
            context.startActivity(intent)
        }
    }
}