package com.example.studentmarket.core.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class Store (
    @SerializedName("userID") val userID:Int,
    @SerializedName("storeName") val storeName: String,
    @SerializedName("storeDelivery") val storeDelivery:String
        ): Parcelable