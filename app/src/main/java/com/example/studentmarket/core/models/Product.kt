package com.example.studentmarket.core.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class Product(
    @SerializedName("prodID") val prodID: Int,
    @SerializedName("categoryID") val categoryID: Int,
    @SerializedName("prodDescription") var prodDescription: String,
    @SerializedName("prodLive") var prodLive: Boolean,
    @SerializedName("prodDelivery") var prodDelivery: String,
    @SerializedName("prodPicture") var prodImage: String,
    @SerializedName("prodName") var prodName: String,
    @SerializedName("prodPrice") var prodPrice: Float,
    @SerializedName("prodRating") var prodRating: Float,
    @SerializedName("prodRange") var prodRange: Int

    //var prodPicture : String, val prodName:String, val prodPrice:Float, val prodRating: Float?, val prodRange:Int
): Parcelable

data class ErrorResponseProduct(val message: String?)
