package com.example.studentmarket.core.api

import com.example.studentmarket.core.models.Category
import com.example.studentmarket.core.models.Order
import com.example.studentmarket.core.models.Product
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface APIService {
    //val baseUrl = "https://studentmarketapp.herokuapp.com"

    @GET("/order/?format=json")  //this is a get query, which essentially says:"get whatever is at this url"
    fun getOrders() : Call<List<Order>>

    @GET("/product/?format=json")
    fun getProducts(): Call<List<Product>>

    @GET("/category/?format=json")
    fun getCategories(): Call<List<Category>>

    @GET("/category/{id}?format=json")
    fun getSavedProducts(@Path("id") productID:Int): Call<List<Product>>

    @GET("product")  //query to get all products with this category id TODO fix query
    //fun getProductsInCategory(@Path("id") categoryID: Int): Call<List<Product>>
    fun getProductsInCategory(
        @Query("categoryID") categoryID: Int
    ) : Call<List<Product>>

    @POST("order")
    fun addToBag(@Body order: Order): Call<Order>
}