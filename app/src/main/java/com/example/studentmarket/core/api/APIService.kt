package com.example.studentmarket.core.api

import com.example.studentmarket.core.models.*
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface APIService {
    //val baseUrl = "https://studentmarketapp.herokuapp.com"

    @GET("order")  //this is a get query, which essentially says:"get whatever is at this url" todo specify order details
    fun getOrders(
        @Query("userID") userID: Int
    ) : Call<List<Order>>

    @GET("/product/?format=json")
    fun getProducts(): Call<List<Product>>

    @GET("/category/?format=json")
    fun getCategories(): Call<List<Category>>

    @GET("saved")
    fun getSavedProducts(
        @Query("userID") userID: Int
    ): Call<List<Saved>>

    @GET("/product/{id}/")
    fun getProduct(
        @Path("id") prodID: Int
    ): Call<Product>

    @GET("product")
    fun getProductsInCategory(
        @Query("categoryID") categoryID: Int
    ) : Call<List<Product>>

    @GET("store")
    fun getStore(
        @Query("userID") userID: Int
    ) : Call<List<Store>>

    @POST("/order/?format=json")
    fun addToBag(@Body order: Order): Call<Order>

    @POST("/saved/?format=json")
    fun saveProduct(@Body saved: Saved): Call<Saved>
}