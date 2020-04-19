package com.assignment.movies

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(context: Context) : RecyclerView.Adapter<RecyclerAdapter.Holder>() {
    private var context: Context? = null

    init {
        this.context = context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(LayoutInflater.from(context).inflate(R.layout.movie_list, null, false))
    }

    override fun getItemCount(): Int {
        return 1
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {

    }

    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var movieImage: ImageView? = null
        private var title: TextView? = null
        private var rating: TextView? = null
        private var date: TextView? = null
        private var overView:TextView?=null

        init {
            movieImage = itemView.findViewById(R.id.image)
            title = itemView.findViewById(R.id.TitleOfMovie)
            date = itemView.findViewById(R.id.dateOfMovie)
            rating = itemView.findViewById(R.id.ratingPercent)
            overView=itemView.findViewById(R.id.OverView)
        }
    }

}