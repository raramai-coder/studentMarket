package com.example.studentmarket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class PaymentGateway1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_payment_gateway)


        //region Checkout Payment Gateway 2 Button
        //TODO: Write logic to skip to map slider button AND set coordinates
        val btnMapSlider = findViewById<Button>(R.id.button_payment_checkout)
        btnMapSlider.setOnClickListener {
            val intent = Intent(this, PaymentGateway2::class.java)
//            btn_map_slider.setTextColor("FFFFFF")
            startActivity(intent)
            finish()
        }
        //endregion Checkout Payment Gateway Button

        supportActionBar?.hide()
    }
}