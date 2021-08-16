package com.example.studentmarket.core.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class User(

    @SerializedName("userID") val userID: Int,
    @SerializedName("userName") val userName: String,
    @SerializedName("userEmail") var userEmail: String,
    @SerializedName("userUniversity") var userUniversity: String,
    @SerializedName("userPassword") var userPassword: String,


) : Parcelable