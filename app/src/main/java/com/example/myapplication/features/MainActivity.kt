package com.example.myapplication.features

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.transaction
import com.example.myapplication.R
import com.example.myapplication.features.home.HomeFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.transaction {
                replace(
                    R.id.container,
                    HomeFragment.newInstance()
                )
            }
        }
    }

}
