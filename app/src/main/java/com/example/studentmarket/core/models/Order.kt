package com.example.studentmarket.core.models

import android.os.Parcelable
//import kotlinx.parcelize.Parcelize
import kotlinx.android.parcel.Parcelize
import com.google.gson.annotations.SerializedName

@Parcelize
class Order (
    //var id: Int = 0, //added id
    @SerializedName("quantity") var quantity: Int,
    @SerializedName("prodName") val prodName:String,
    @SerializedName("orderAmount") var orderAmount: Int,
    @SerializedName("unitPrice")val unitPrice: Float,
    @SerializedName("prodID")val prodID: String,
    @SerializedName("userID")val userID:String

): Parcelable

data class ErrorResponseOrder(val message:String?)