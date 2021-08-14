package com.example.studentmarket.core.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class Saved (
        //@SerializedName("savedID") val savedID : Int,
        @SerializedName("prodID") val prodID: Int,
        @SerializedName("userID") val userID: Int,
        //@SerializedName("dateSaved") val dateSaved: Time
        ): Parcelable