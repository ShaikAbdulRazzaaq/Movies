package com.assignment.movies

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.assignment.movies.fragments.ViewPager


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPagerFragmentSaved = supportFragmentManager.findFragmentById(R.id.mainFragment)
        if (viewPagerFragmentSaved == null) {
            val viewPagerFragment = ViewPager()
            val fragmentManager = supportFragmentManager
            val fragmentTransaction =
                fragmentManager.beginTransaction()
            fragmentTransaction.add(R.id.mainFragment, viewPagerFragment)
            fragmentTransaction.commit()
        }
    }

}