package com.example.studentmarket

import android.graphics.Color
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.text.method.LinkMovementMethod
import kotlinx.android.synthetic.main.fragment_privacy_popup.*

class Register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        setUpHyperlink()
        //region Register Button
        val register_btn = findViewById<Button>(R.id.register_btn_rg)

        //when you click this button it opens up the main activity
        register_btn.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }

    fun setUpHyperlink() {
        val linkPrivacy = findViewById<TextView>(R.id.textview_terms_conditions)
        val linkTermsConditions = findViewById<TextView>(R.id.textview_privacy_policy)
//        val linkTextView = findViewByID<TextView>(R.id.fragment_privacy_popup)
        linkPrivacy.setMovementMethod(LinkMovementMethod.getInstance())
        linkTermsConditions.setMovementMethod(LinkMovementMethod.getInstance())
        linkPrivacy.setLinkTextColor(Color.BLUE)
        linkTermsConditions.setLinkTextColor(Color.BLUE)
    }
}