package com.example.studentmarket

import android.app.ProgressDialog
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_add_product.*
import java.net.URI

class AddProduct : AppCompatActivity() {

    lateinit var imageURI: Uri

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_product)
        supportActionBar?.hide()

        addImage1_btn_ap.setOnClickListener {
            selectImage()
        }

        addImage2_btn_ap.setOnClickListener {
            selectImage()
        }

        addImage3_btn_ap.setOnClickListener {
            selectImage()
        }
    }

    private fun selectImage(){
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT

        startActivityForResult(intent,100)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == 100 && resultCode == RESULT_OK){
            imageURI = data?.data!!
            uploadImage()
        }
    }

    private fun uploadImage(){
        val progressDialog = ProgressDialog(this)
        progressDialog.setMessage("Uploading Images...")
        progressDialog.setCancelable(false)
        progressDialog.show()


    }
}