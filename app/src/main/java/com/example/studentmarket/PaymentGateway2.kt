package com.example.studentmarket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class PaymentGateway2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_payment_success)

        //region Checkout Back To Map Slider
        //TODO: Write logic to skip to map slider button AND set coordinates
        val btnMapSlider = findViewById<Button>(R.id.button_payment_home)
        btnMapSlider.setOnClickListener {
            val intent = Intent(this, MapSliderActivity2::class.java)
//            btn_map_slider.setTextColor("FFFFFF")
            startActivity(intent)
            finish()
        }
        //endregion Checkout Back To Map Slider


        supportActionBar?.hide()
    }
}