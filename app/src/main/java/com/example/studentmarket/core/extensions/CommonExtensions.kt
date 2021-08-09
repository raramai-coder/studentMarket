package com.example.studentmarket.core.extensions

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.example.studentmarket.core.models.ErrorResponse
import com.google.gson.GsonBuilder
import okhttp3.ResponseBody
import retrofit2.http.Body
import java.io.IOException
import java.time.Duration


fun Context.showErrorMessage(errorBody: ResponseBody, duration: Int = Toast.LENGTH_SHORT){

    val gson = GsonBuilder().create()

    try{
        val errorResponse = gson.fromJson(errorBody.string(), ErrorResponse::class.java)
        toast(errorResponse.message!!,duration)

    }catch (e: IOException) {
        Log.e("Exception",e.toString())

    }
}

fun Context.toast(msg:String,duration: Int = Toast.LENGTH_SHORT){
    Toast.makeText(this,msg,duration).show()
}