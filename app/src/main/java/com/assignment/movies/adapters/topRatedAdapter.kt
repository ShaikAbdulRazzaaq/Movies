package com.assignment.movies.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.assignment.movies.R
import com.assignment.movies.data.Result
import com.squareup.picasso.Picasso

class topRatedAdapter(context: Context,list:List<Result>,thumbnailClicked: thumbnailClicked) : RecyclerView.Adapter<topRatedAdapter.TRViewHolder>() {
    private val context:Context?=null
    private var list:List<Result>?=null
    interface thumbnailClicked{
        fun thumbnail(index:Int)
    }
    private val imageUrl = "https://image.tmdb.org/t/p/w185"
    class TRViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) ,View.OnClickListener {
        var thumbnailImage: ImageView=itemView.findViewById(R.id.thumbnailImage)
        var thumnailTextName:TextView=itemView.findViewById(R.id.thumnailTextName)
        override fun onClick(v: View?) {
           val index=adapterPosition
            val thumbnailClicked:thumbnailClicked?=null
            thumbnailClicked?.thumbnail(index)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TRViewHolder {
       return TRViewHolder(LayoutInflater.from(context).inflate(R.layout.movies_list,parent,false))
    }

    override fun getItemCount(): Int {
      return list?.size!!
    }

    override fun onBindViewHolder(holder: TRViewHolder, position: Int) {
        val r:Result= list!![position]
        Picasso.get().load(imageUrl+r.posterPath).into(holder.thumbnailImage)
        holder.thumnailTextName.text = r.title
    }

}