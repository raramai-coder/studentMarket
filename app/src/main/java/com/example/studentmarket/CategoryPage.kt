package com.example.studentmarket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class CategoryPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_page)

        supportActionBar?.hide()
    }
}