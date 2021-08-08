package com.example.studentmarket.core.api

import com.example.studentmarket.core.models.Order
import retrofit2.Call
import retrofit2.http.GET

interface APIService {

    @GET("/order/?format=json")
    fun getOrders(): Call<List<Order>>
}