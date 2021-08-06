package com.example.studentmarket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        //region Bottom Navigation Bar
        //a reference to the actual navigation bar I created in the main activity xml
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_nav_bar)
        //this is a controller which changes which fragment we are viewing, it also located in the main activity xml. It holds the navigation graph we created
        val navController = findNavController(R.id.fragment)
        //this sets up the navigation controller so it can actually switch between fragments when clicked
        bottomNavigation.setupWithNavController(navController)
        //endregion


    }
}