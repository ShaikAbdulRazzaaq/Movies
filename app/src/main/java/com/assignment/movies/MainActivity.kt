package com.assignment.movies

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.assignment.movies.fragments.viewPager
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPagerFragmentSaved=supportFragmentManager.findFragmentById(R.id.mainFragment)
        if(viewPagerFragmentSaved==null){
            val viewPagerFragment = viewPager()
            val fragmentManager = supportFragmentManager
            val fragmentTransaction =
                fragmentManager.beginTransaction()
            fragmentTransaction.add(R.id.mainFragment, viewPagerFragment)
            fragmentTransaction.commit()
            Toast.makeText(this,"Fragment Created",Toast.LENGTH_SHORT).show()
        }
    }

}