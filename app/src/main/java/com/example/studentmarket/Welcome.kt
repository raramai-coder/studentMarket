package com.example.studentmarket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.models.SlideModel

class Welcome : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        supportActionBar?.hide()
        //region Welcome Images Slider
        val imageList = ArrayList<SlideModel>() // Create image list

        //all the images that will be displayed in the welcome slider are added to the array
        imageList.add(SlideModel(R.drawable.feminine_welcome_instagram_post))
        imageList.add(SlideModel(R.drawable.welcome_2))
        imageList.add(SlideModel(R.drawable.welcome_3))

        //initialize the slider and set its images
        val welcomeImages = findViewById<ImageSlider>(R.id.welcome_image_slider)
        welcomeImages.setImageList(imageList)
        //endregion

        //region Buttons
        //these are all the buttons on the screen: the register, login and skip button

        //region Get Started Button
        val getStarted_btn = findViewById<Button>(R.id.getStarted_btn_wl)

        //when you click this button it opens up the registration activity
        getStarted_btn.setOnClickListener {
            val intent = Intent(this,Register::class.java)
            startActivity(intent)
        }
        //endregion

        //region Login Button
        val login_btn = findViewById<Button>(R.id.login_btn_wl)

        //when you click this button it opens up the login activity
        login_btn.setOnClickListener {
            val intent = Intent(this,Login::class.java)
            login_btn.setTextColor(getColor(R.color.primary_teal))
            startActivity(intent)
        }
        //endregion

        //region Skip Button
        val skip_btn = findViewById<Button>(R.id.skip_btn_wl)

        //when you click this button it goes straight to the home page without logging the user in
        //TODO: write logic that ensures that the user cannot save, buy or open cart without logging in first
        skip_btn.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            skip_btn.setTextColor(getColor(R.color.primary_teal))
            startActivity(intent)
            finish()
        }
        //endregion

        //region Map Slider
        //TODO: Write logic to skip to map slider button AND set coordinates
        val btn_map_slider = findViewById<Button>(R.id.button_map_slider)
        btn_map_slider.setOnClickListener {
            val intent = Intent(this, MapSliderActivity::class.java)
            btn_map_slider.setTextColor(getColor(R.color.primary_teal))
            startActivity(intent)
            finish()
        }
        //endregion Map Slider
        //endregion
    }
}