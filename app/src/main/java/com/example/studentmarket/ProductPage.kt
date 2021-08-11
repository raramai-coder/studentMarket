package com.example.studentmarket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.models.SlideModel
import com.example.studentmarket.core.extensions.toast
import com.example.studentmarket.core.models.Product
import com.google.android.material.snackbar.Snackbar
import com.ms.square.android.expandabletextview.ExpandableTextView
import kotlinx.android.synthetic.main.activity_product_page.*
import org.w3c.dom.Text

class ProductPage : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_page)

        supportActionBar?.hide()

        //getting product from previous intent
        val bundle = intent.getBundleExtra("productBundle")
        val product = bundle!!.getParcelable<Product>("product") as Product


        //region Product Images Slider
        val imageList1 = ArrayList<SlideModel>() // Create image list

        //all the images that will be displayed in the welcome slider are added to the array
        imageList1.add(SlideModel("https://res.cloudinary.com/hb9ogjlea/" + product.prodImage))
        imageList1.add(SlideModel(R.drawable.welcome_2))
        imageList1.add(SlideModel(R.drawable.welcome_3))

        //initialize the slider and set its images
        val welcomeImages = findViewById<ImageSlider>(R.id.product_image_slider_ppg)
        welcomeImages.setImageList(imageList1)
        //endregion

        //region initialising all the elements from the layout
        val productDescription : ExpandableTextView = findViewById(R.id.expand_text_view)
        val productName: TextView = findViewById(R.id.product_name_txt_ppg)
        val productPrice : TextView = findViewById(R.id.product_price_txt_ppg)
        val productRating : TextView = findViewById(R.id.product_rating_txt_ppg)


        //productDescription.text = "Using the library is really simple, just look at the source code of the provided sample. (Look at the SampleTextListAdapter.java for the use within a ListView)W/libEGL: EGLNativeWindowType 0x790304c8d0 disconnect failed/OpenGLRenderer: endAllActiveAnimators on 0x78e5c69000 (RippleDrawable) with handle 0x78e5d9baaW/libEGL: EGLNativeWindowType 0x796def3750 disconnect failedW/Settings: Setting device_provisioned has moved from android.provider.Settings.Secure to android.provider.Settings.Global.V/HiTouch_HiTouchSensor: User setup is finishedV/AudioManager: querySoundEffectsEnabled.V/AudioManager: querySoundEffectsEnabled..V/AudioManager: querySoundEffectsEnabled...udioManager: querySoundEffectsEnabled..AudioManager: querySoundEffectsEnabled...udioManager: querySoundEffectsEnabled/AudioManager: querySoundEffectsEnabled...udioManager: querySoundEffectsEnabled...IInputConnectionWrapper: getExtractedText on inactive InputConnectiInputConnectionWrapper: getTextBeforeCursor on inactive InputConnectionibEGL: EGLNativeWindowType 0x796def34d0 disconnect failedActivityThread: Handle window ActivityRecord{f770ba3 token=android.os.BinderProxy@ff91635 {com.example.studentmarket/com.example.studentmarket.ProductPage}} visibility: falseZrHung.AppEyeUiProbe: not watching, wait.\nThe important thing to note is that the view Ids for TextView and ImageButton must be set to respectively for this library to work.Also, you can optionally set the following attributes in your layout xml file to customize the behavior of the ExpandableTextView."

        val addToCart : View = findViewById(R.id.cart_fab_ppg)

        addToCart.setOnClickListener {
            Snackbar.make(addToCart, "Added to Bag", Snackbar.LENGTH_LONG)
                .setAction("Action", null)
                .show()
        }


        //populating the product page with this intent
        productName.text = product!!.prodName
        productDescription.text = product!!.prodDescription
        productPrice.text = "R" + product!!.prodPrice.toString() +"0"
        productRating.text = "Rating: " + product!!.prodRating.toString() +"/5"


    }

}