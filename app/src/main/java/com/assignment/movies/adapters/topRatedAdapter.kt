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
import org.w3c.dom.Text
import java.lang.reflect.Array.get

class topRatedAdapter(context: Context,list:List<Result>) : RecyclerView.Adapter<topRatedAdapter.TRViewHolder>() {
    private val context:Context?=null
    private var list:List<Result>?=null

    class TRViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var thumbnailImage: ImageView=itemView.findViewById(R.id.thumbnailImage)
        var thumnailTextName:TextView=itemView.findViewById(R.id.thumnailTextName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TRViewHolder {
       return TRViewHolder(LayoutInflater.from(context).inflate(R.layout.movies_list,parent,false))
    }

    override fun getItemCount(): Int {
      return list?.size!!
    }

    override fun onBindViewHolder(holder: TRViewHolder, position: Int) {
        var r:Result= list!![position]

    }

}