package com.example.studentmarket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import co.za.mtn.academy.itsgotime.core.api.RetrofitClient
import com.example.studentmarket.adapters.CardAdapter
import com.example.studentmarket.adapters.ProductStoreSellerAdapter
import com.example.studentmarket.core.api.APIService
import com.example.studentmarket.core.models.*
import com.example.studentmarket.ui.home
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_store.*
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StorePage : AppCompatActivity() {

    companion object{
        private const val TAG = ""
    }

    private val apiService: APIService by lazy { RetrofitClient.apiService }
    private var stores: List<Store> = mutableListOf()
    private var products: List<Product> = mutableListOf()
    private lateinit var prodAdapter: ProductStoreSellerAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store)

        supportActionBar?.hide()

        val storeName = findViewById<TextView>(R.id.textview_store_name)

        val bundle = intent.getBundleExtra("userBundle")
        val storeOwner = bundle!!.getInt("userID")

        storeproduct_rv_spg.layoutManager = LinearLayoutManager(this)


       /* Snackbar.make(storeName,storeOwner.toString(),Snackbar.LENGTH_LONG)
           .setAction("Action", null)
           .show()*/

        getStore(storeOwner)
        fetchProducts(storeOwner)
    }




    private fun getStore(storeOwner: Int){
        apiService.getStore(storeOwner).enqueue(object : Callback<List<Store>> {
            override fun onResponse(call: Call<List<Store>>?, response: Response<List<Store>>) {
                if(response.isSuccessful){
                    Log.i(TAG, "products loaded from API $response")

                    response.body()?.let {
                        stores = it
                    }

                    if (stores.isNotEmpty())
                        setupStorePage(stores[0])       //furthermore if there are items in the products table then set up the recyclerview with them
                    else
                        Toast.makeText(this@StorePage, "No Products to Show", Toast.LENGTH_SHORT).show()

                }else{
                    Log.i(TAG, "error $response")
                }
            }

            override fun onFailure(call: Call<List<Store>>, t: Throwable) {
                Toast.makeText(this@StorePage, t.message?:"Error Fetching Results", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun setupStorePage(store:Store){
        textview_store_name.text = store.storeName
        texview_store_description.text = store.storeDescription
        textview_store_location_customers.text = "Customers Served: " + store.customersServed.toString()
        textview_store_location_rating.text = "Average Rating: " + store.storeRating


        Picasso.get()
            .load("https://res.cloudinary.com/hb9ogjlea/" + store.storePicture)
            .placeholder(R.drawable.icon_student_market)
            .error(R.drawable.welcome_2)
            .into(image_view_store_image)
    }

    private fun fetchProducts(storeOwner: Int) {

        apiService.getStoreProducts(storeOwner).enqueue(object : Callback<List<Product>> {    //calling the api service and telling to specifically call the query in the getProducts function, which is declared in the APIService class

            override fun onResponse(call: Call<List<Product>>?, response: Response<List<Product>>) {
                if (response.isSuccessful) {
                    Log.i(TAG, "products loaded from API $response")

                    response.body()?.let {
                        products = it                               //find the products in the response and make them populate this list called products
                    }

                    if (products.isNotEmpty())
                        setupRecyclerView(products)       //furthermore if there are items in the products table then set up the recyclerview with them
                    else
                        Toast.makeText(this@StorePage, "No Products to Show", Toast.LENGTH_SHORT).show()


                } else {
                    Log.i(TAG, "error $response")
                    //showErrorMessage(response.errorBody()!!)
                }
            }

            override fun onFailure(call: Call<List<Product>>?, t: Throwable) {
                Toast.makeText(this@StorePage, t.message?:"Error Fetching Results", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun setupRecyclerView(products: List<Product>) {     //this function attaches the adapter to the recyclerview and populates it with the data collected from the database
        prodAdapter = ProductStoreSellerAdapter(products)
        storeproduct_rv_spg.adapter = prodAdapter

        prodAdapter.setOnButtonClickListener(object : ProductStoreSellerAdapter.onProductClickListener{
            override fun viewProduct(position: Int) {
                val intent = Intent(this@StorePage, ProductPage::class.java)
                var bundle = Bundle()
                bundle.putParcelable("product", products[position])
                intent.putExtra("productBundle", bundle)
                startActivity(intent)
            }

            override fun addToBag(product: Product) {
                val newOrder: Order = Order("keep it nice",1, product.prodName,1,product.prodPrice,product.prodID,home.userID)

                //Call<Order> call = apiService.addToBag(newOrder)

                apiService.addToBag(newOrder).enqueue(object : Callback<Order> {    //calling the api service and telling to specifically call the query in the getProducts function, which is declared in the APIService class

                    override fun onResponse(call: Call<Order>, response: Response<Order>) {
                        if (response.isSuccessful) {
                            Log.i(TAG, "products loaded from API $response")

                            /*response.body()?.let {
                                products = it                               //find the products in the response and make them populate this list called products
                            }*/

                            //Toast.makeText(this@ProductPage, response.body()!!.toString(), Toast.LENGTH_SHORT).show()
                            /* Toast.makeText(this@ProductPage, response.code()!!.toString(), Toast.LENGTH_SHORT).show()*/

                            Snackbar.make(textview_store_location_rating, "Added to Bag", Snackbar.LENGTH_LONG)
                                .setAction("Action", null)
                                .show()

                            /* Toast.makeText(this@ProductPage, "No Products to Show", Toast.LENGTH_SHORT).show()
                             Snackbar.make(addToCart, "Failed to Bag", Snackbar.LENGTH_LONG)
                                 .setAction("Action", null)
                                 .show()*/


                        } else {
                            Log.i(TAG, "error $response")
                            //showErrorMessage(response.errorBody()!!)
                        }
                    }

                    override fun onFailure(call: Call<Order>?, t: Throwable) {
                        Toast.makeText(this@StorePage, t.message?:"Error Adding to Bag", Toast.LENGTH_SHORT).show()
                    }
                })
            }

            override fun saveProduct(product: Product) {
                //saved.user1.AddSave(product)
                val savedProduct= Saved(product.prodID,home.userID)
                apiService.saveProduct(savedProduct).enqueue(object : Callback<Saved> {    //calling the api service and telling to specifically call the query in the getProducts function, which is declared in the APIService class

                    override fun onResponse(call: Call<Saved>, response: Response<Saved>) {
                        if (response.isSuccessful) {
                            Log.i(TAG, "products loaded from API $response")


                            Snackbar.make(recycler_view_store_products, "Saved Product", Snackbar.LENGTH_LONG)
                                .setAction("Action", null)
                                .show()

                            /* Toast.makeText(this@ProductPage, "No Products to Show", Toast.LENGTH_SHORT).show()
                             Snackbar.make(addToCart, "Failed to Bag", Snackbar.LENGTH_LONG)
                                 .setAction("Action", null)
                                 .show()*/


                        } else {
                            Log.i(TAG, "error $response")
                            //showErrorMessage(response.errorBody()!!)
                        }
                    }

                    override fun onFailure(call: Call<Saved>?, t: Throwable) {
                        Toast.makeText(this@StorePage, t.message?:"Error Adding to Bag", Toast.LENGTH_SHORT).show()
                    }
                })
            }

        })


    }

}