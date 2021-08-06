package com.example.studentmarket

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity

class Login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setSupportActionBar(findViewById(R.id.toolbar))

        //region Login Button
        val login_btn = findViewById<Button>(R.id.login_btn_lg)

        //when you click this button it opens up the main activity
        login_btn.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
        //endregion

        //region Forgot Password Button
        val forgot_btn = findViewById<Button>(R.id.forgot_btn_lg)

        //when you click this button it changes color, will have to code later what happens when the user forgets their password
        forgot_btn.setOnClickListener {
            forgot_btn.setTextColor(getColor(R.color.primary_teal))
        }
        //endregion


    }
}