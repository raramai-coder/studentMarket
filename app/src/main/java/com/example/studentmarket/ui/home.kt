package com.example.studentmarket.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.studentmarket.R
import kotlinx.android.synthetic.main.fragment_home.*
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.studentmarket.adapters.CardAdapter
import androidx.lifecycle.ViewModelProvider
import co.za.mtn.academy.itsgotime.core.api.RetrofitClient
import com.example.studentmarket.CategoryPage
import com.example.studentmarket.ProductPage
import com.example.studentmarket.Store
import com.example.studentmarket.adapters.CategoryAdapter
import com.example.studentmarket.core.api.APIService
import com.example.studentmarket.core.models.Category
import com.example.studentmarket.core.models.Product
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A simple [Fragment] subclass.
 * Use the [home.newInstance] factory method to
 * create an instance of this fragment.
 */

class home : Fragment() {

    companion object {
        fun newInstance() = home()
        private const val TAG = ""
    }


    private val apiService: APIService by lazy { RetrofitClient.apiService }   //initialize the API Service that stores the request that connects to our database
    private lateinit var viewModel: homeViewModel
    private var products: List<Product> = mutableListOf()   //the list of products that will be returned by our database is stored in this variable
    private lateinit var prodAdapter: CardAdapter                        //the adapter that works with our product card
    private var categories: List<Category> = mutableListOf()   //the list of categories that will be returned by our database is stored in this variable
    private lateinit var catAdapter: CategoryAdapter       //the adapter that works with our category card

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(homeViewModel::class.java)
        // TODO: Use the ViewModel

        // Recycler_view_items' layout manager component is set to LinearLayoutManager instance. This instance of Main activity is context
        recycler_view_store_products.layoutManager = LinearLayoutManager(activity)
        recycler_view_categories.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)

        //Recycler_view_items' adapter component is set to ContactAdapter. Contact list is sent using func
        //recycler_view_products.adapter = CardAdapter(getProductList())
        //recycler_view_categories.adapter = CategoryAdapter(getCategoryList())

        fetchProducts()     //calling the function that gets the products from the database and feeds them to the recyclerview
        fetchCategories()    //calling the function that gets the products from the database and feeds them to the recyclerview
    }



    private fun fetchProducts() {

        apiService.getProducts().enqueue(object : Callback<List<Product>> {    //calling the api service and telling to specifically call the query in the getProducts function, which is declared in the APIService class

            override fun onResponse(call: Call<List<Product>>?, response: Response<List<Product>>) {
                if (response.isSuccessful) {
                    Log.i(TAG, "products loaded from API $response")

                    response.body()?.let {
                        products = it                               //find the products in the response and make them populate this list called products
                    }

                    if (products.isNotEmpty())
                        setupRecyclerView(products)       //furthermore if there are items in the products table then set up the recyclerview with them
                    else
                        Toast.makeText(activity, "No Products to Show", Toast.LENGTH_SHORT).show()


                } else {
                    Log.i(home.TAG, "error $response")
                    //showErrorMessage(response.errorBody()!!)
                }
            }

            override fun onFailure(call: Call<List<Product>>?, t: Throwable) {
                Toast.makeText(activity, t.message?:"Error Fetching Results", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun setupRecyclerView(products: List<Product>) {     //this function attaches the adapter to the recyclerview and populates it with the data collected from the database
        prodAdapter = CardAdapter(products)
        recycler_view_store_products.adapter = prodAdapter

        prodAdapter.setOnButtonClickListener(object : CardAdapter.onProductClickListener{
            override fun viewProduct(position: Int) {
                val intent = Intent(activity, ProductPage::class.java)
                var bundle = Bundle()
                bundle.putParcelable("product", products[position])
                intent.putExtra("productBundle", bundle)
                startActivity(intent)
            }

            override fun viewStore(position: Int) {
                val intent = Intent(activity, Store::class.java)
                //intent.putExtra("product", products[position])
                startActivity(intent)
            }

        })


    }


    private fun fetchCategories() {

        apiService.getCategories().enqueue(object : Callback<List<Category>> {

            override fun onResponse(call: Call<List<Category>>?, response: Response<List<Category>>) {
                if (response.isSuccessful) {
                    Log.i(TAG, "categories loaded from API $response")

                    response.body()?.let {
                        categories = it
                    }

                    if (categories.isNotEmpty())
                        setupCategoryRecyclerView(categories)
                    else
                        Toast.makeText(activity, "No Categories to Show", Toast.LENGTH_SHORT).show()
                    //Log.i(TAG,"orders is empty")

                } else {
                    Log.i(home.TAG, "error $response")
                    Toast.makeText(activity, "Failed to Load Categories", Toast.LENGTH_SHORT).show()
                    //showErrorMessage(response.errorBody()!!)
                }
            }

            override fun onFailure(call: Call<List<Category>>?, t: Throwable) {
                Toast.makeText(activity, t.message?:"Error Fetching Results", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun setupCategoryRecyclerView(products: List<Category>) {
        catAdapter = CategoryAdapter(categories)
        recycler_view_categories.adapter = catAdapter

        catAdapter.setOnButtonClickListener(object : CategoryAdapter.onCategoryClickListener{
            override fun viewCategory(position: Int) {
                val intent = Intent(activity, CategoryPage::class.java)
                var bundle = Bundle()
                bundle.putParcelable("category", categories[position])
                intent.putExtra("categoryBundle", bundle)
                startActivity(intent)
            }


        })

        //region code for what could happen if card is clicked (commented out)
        // add on click for elements
        /*catAdapter.onItemClick = { user ->

            val intent = Intent(this, UserDetailsActivity::class.java)
            intent.putExtra("User", user)
            startActivity(intent)
        }*/
        //endregion
    }

    //region old code for RecyclerViews
    /** Shagan
     * Get Product List and return list of product objects
     * Param: None so far, can update to include product filter as param...
     * Returns: ArrayList of products objects
    private fun getProductList(): ArrayList<String> {
        val productList = ArrayList<String>()
        val itemCount = 15 // Find size of product data
        for (i in 1..itemCount){
            productList.add("$i")

            *//** Shagan for Nicolle (?)
             * The code for adding the product objects
             * Please initialize and add from the dB
             *//*
        }
        return productList
    }

    private fun getCategoryList(): ArrayList<String> {
        val categoryList = ArrayList<String>()
        val itemCount = 10 // Find size of product data
        for (i in 1..itemCount){
            categoryList.add("$i")

            *//** Shagan for Nicolle (?)
             * The code for adding the product objects
             * Please initialize and add from the dB
             *//*
        }
        return categoryList
    }*/
    //endregion

}