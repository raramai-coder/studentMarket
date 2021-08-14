package com.example.studentmarket.core.models

import android.os.Parcelable
import com.google.gson.annotations.Expose
//import kotlinx.parcelize.Parcelize
import kotlinx.android.parcel.Parcelize
import com.google.gson.annotations.SerializedName

//This is the class for Orders, it's serialized variables correspond to the
//orders viewSet in our database models

@Parcelize
class Order (
    //var id: Int = 0, //added id
    @SerializedName("orderNote") var orderNote: String,
    @SerializedName("quantity")  var quantity: Int,
    @SerializedName("prodName") val prodName:String,
    @SerializedName("orderAmount") var orderAmount: Int,
    @SerializedName("unitPrice")val unitPrice: Float,
    @SerializedName("prodID")val prodID: Int,
    @SerializedName("userID")val userID:Int

): Parcelable

data class ErrorResponse(val message:String?)