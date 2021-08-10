package com.example.studentmarket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Store : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store)

        supportActionBar?.hide()
    }


}