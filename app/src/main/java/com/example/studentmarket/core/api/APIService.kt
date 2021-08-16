package com.example.studentmarket.core.api

import com.example.studentmarket.core.models.*
import com.google.gson.annotations.SerializedName
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface APIService {
    //val baseUrl = "https://studentmarketapp.herokuapp.com"

    //this gets all the orders that belong to a specific user to display them in the cart fragment
    @GET("order")  //this is a get query, which essentially says:"get whatever is at this url"
    fun getOrders(
        @Query("userID") userID: Int
    ) : Call<List<Order>>

    //this gets all the products to show them on the home screen, and search fragment
    @GET("/product/?format=json")
    fun getProducts(): Call<List<Product>>

    //this gets all the categories to show them on th ehome fragment
    @GET("/category/?format=json")
    fun getCategories(): Call<List<Category>>

    //this gets all the products that the user has saved and displays them in the saved fragment
    @GET("saved")
    fun getSavedProducts(
        @Query("userID") userID: Int
    ): Call<List<Saved>>

    //this gets a specific product by id, its is called after getSavedProducts since that returns product ID's
    @GET("/product/{id}/")
    fun getProduct(
        @Path("id") prodID: Int
    ): Call<Product>

    //this gets all the products in a specific category
    @GET("product")
    fun getProductsInCategory(
        @Query("categoryID") categoryID: Int
    ) : Call<List<Product>>

    //this gets the store associated with a specific user once 'view store' has been pressed
    @GET("store")
    fun getStore(
        @Query("userID") userID: Int
    ) : Call<List<Store>>

    //this adds a product to the user's bag
    @POST("/order/?format=json")
    fun addToBag(@Body order: Order): Call<Order>

    //saves a product for a user
    @POST("/saved/?format=json")
    fun saveProduct(@Body saved: Saved): Call<Saved>

    //gets all products after a serch that correspond to the searched products
    @GET ("/product/")
    fun search(
        @Query("search") searchTerm: String
    ): Call<List<Product>>

    //get the specified user with those login credentials
    @GET("/user/")
    fun loginUser(
        @Query("userEmail") userEmail: String,
        @Query("userPassword") userPassword: String
    ): Call<List<User>>

    //this registers a specific user to the db
    @POST("/user/?format=json")
    fun registerUser( @Body user:User):Call<User>

    //this registers a product to the db
    @POST("/user/?format=json")
    fun addProduct( @Body product:Product):Call<Product>

    //registers a new store to the db for the user
    @POST("/store/?format=json")
    fun registerStore(@Body store: Store): Call<Store>

    /*@POST("/store/")
    fun registerStore(
        @Field("userID") userID: Int,
        @Field("storeName") storeName: String,
        @Field("storeDelivery[]") items: List<Integer>,
        @Field("storeRating") storeRating: Float,
    ): Call<Store>*/

   /* @Multipart
    @POST("upload")
    fun registerStoreImage(
        @Part("storeImage") MultipartBody.Part photo
    )*/
}