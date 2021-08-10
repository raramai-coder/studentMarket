package com.example.studentmarket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.models.SlideModel

class ProductPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_page)

        supportActionBar?.hide()

        //region Product Images Slider
        val imageList1 = ArrayList<SlideModel>() // Create image list

        //all the images that will be displayed in the welcome slider are added to the array
        imageList1.add(SlideModel(R.drawable.icon_student_market))
        imageList1.add(SlideModel(R.drawable.welcome_2))
        imageList1.add(SlideModel(R.drawable.welcome_3))

        //initialize the slider and set its images
        val welcomeImages = findViewById<ImageSlider>(R.id.product_image_slider_ppg)
        welcomeImages.setImageList(imageList1)
        //endregion
    }
}