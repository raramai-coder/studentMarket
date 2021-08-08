package com.example.studentmarket.core.models

data class Order (
    var quantity: Int, val prodName:String, var orderAmount: Int, val unitPrice: Float, val prodID: String, val userID:String

)