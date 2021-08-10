package com.example.studentmarket.core.api

import com.example.studentmarket.core.models.Category
import com.example.studentmarket.core.models.Order
import com.example.studentmarket.core.models.Product
import retrofit2.Call
import retrofit2.http.GET

interface APIService {

    @GET("/order/?format=json")  //this is a get query, which essentially says:"get whatever is at this url"
    fun getOrders() : Call<List<Order>>

    @GET("/product/?format=json")
    fun getProducts(): Call<List<Product>>

    @GET("/category/?format=json")
    fun getCategories(): Call<List<Category>>

}