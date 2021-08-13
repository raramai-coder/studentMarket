package com.example.studentmarket.core.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

//This is the class for Products, it's serialized variables correspond to the
//products viewSet in our database models

@Parcelize
class Product(
    @SerializedName("prodID") val prodID: Int,
    @SerializedName("categoryID") val category: Int,
    @SerializedName("userID") val user: Int,
    @SerializedName("prodDescription") var prodDescription: String,
    @SerializedName("prodLive") var prodLive: Boolean,
    @SerializedName("prodPicture") var prodImage: String,
    @SerializedName("prodName") var prodName: String,
    @SerializedName("prodPrice") var prodPrice: Float,
    @SerializedName("prodRating") var prodRating: Float,
    @SerializedName("prodSaved") var prodSaved: Boolean


): Parcelable


