package com.assignment.movies.adapters

import android.content.Context
import android.content.Intent
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

class topRatedAdapter(context: Context, list: List<Result>) :
    RecyclerView.Adapter<topRatedAdapter.TRViewHolder>() {
    private val context: Context? = null
    private var list: List<Result>? = null

    private val imageUrl = "https://image.tmdb.org/t/p/w185"

    class TRViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var thumbnailImage: ImageView = itemView.findViewById(R.id.thumbnailImage)
        var thumbnailTextName: TextView = itemView.findViewById(R.id.thumnailTextName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TRViewHolder {
        return TRViewHolder(
            LayoutInflater.from(context).inflate(R.layout.movies_list, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return list?.size!!
    }

    override fun onBindViewHolder(holder: TRViewHolder, position: Int) {
        val r: Result = list!![position]
        Picasso.get().load(imageUrl + r.posterPath).into(holder.thumbnailImage)
        holder.thumbnailTextName.text = r.title
        holder.itemView.setOnClickListener {
            val index = holder.adapterPosition
            val intent: Intent = Intent(context, DetailedActivity::class.java)
            context?.startActivity(intent)
        }
    }

}