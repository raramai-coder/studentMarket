package com.example.studentmarket.core.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

//This is the class for Categories, it's serialized variables correspond to the
//categories viewSet in our database models

@Parcelize
class Category (
    @SerializedName("categoryID") val categoryID : Int,
    @SerializedName("catName") val categoryName : String

    ): Parcelable