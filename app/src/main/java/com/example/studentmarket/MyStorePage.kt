package com.example.studentmarket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MyStorePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_store_page)

        supportActionBar?.hide()
    }
}