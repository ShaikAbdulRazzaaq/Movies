package com.assignment.movies.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.assignment.movies.R


class TopRated : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v: View = inflater.inflate(R.layout.top_rated_fragment, container, false)
        val recyclerView: RecyclerView = v.findViewById(R.id.topRatedRecycler)
        recyclerView.layoutManager = LinearLayoutManager(v.context, RecyclerView.VERTICAL, false)
        return (v)
    }

}
