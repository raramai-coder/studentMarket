package com.example.studentmarket.ui

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
import com.example.studentmarket.adapters.CategoryAdapter
import com.example.studentmarket.adapters.CardAdapter
import androidx.lifecycle.ViewModelProvider
import co.za.mtn.academy.itsgotime.core.api.RetrofitClient
import com.example.studentmarket.adapters.OrderAdapter
import com.example.studentmarket.core.api.APIService
import com.example.studentmarket.core.models.Order
import com.example.studentmarket.core.models.Product
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

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

    private val apiService: APIService by lazy { RetrofitClient.apiService }
    private lateinit var viewModel: homeViewModel
    private var products: List<Product> = mutableListOf()
    private lateinit var adapter: CardAdapter

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
        recycler_view_products.layoutManager = LinearLayoutManager(activity)
        recycler_view_categories.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)

        //Recycler_view_items' adapter component is set to ContactAdapter. Contact list is sent using func
        //recycler_view_products.adapter = CardAdapter(getProductList())
        //recycler_view_categories.adapter = CategoryAdapter(getCategoryList())

        fetchProducts()
    }



    private fun fetchProducts() {

        apiService.getProducts().enqueue(object : Callback<List<Product>> {

            override fun onResponse(call: Call<List<Product>>?, response: Response<List<Product>>) {
                if (response.isSuccessful) {
                    //Log.i(TAG, "facilitators loaded from API $response")

                    response.body()?.let {
                        products = it
                    }

                    if (products.isNotEmpty())
                        setupRecyclerView(products)
                    else
                        Toast.makeText(activity, "No Products to Show", Toast.LENGTH_SHORT).show()
                    //Log.i(TAG,"orders is empty")

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

    private fun setupRecyclerView(products: List<Product>) {
        adapter = CardAdapter(products)
        recycler_view_products.adapter = adapter

        // add on click for elements
        /*adapter.onItemClick = { user ->

            val intent = Intent(this, UserDetailsActivity::class.java)
            intent.putExtra("User", user)
            startActivity(intent)
        }*/
    }

    /** Shagan
     * Get Product List and return list of product objects
     * Param: None so far, can update to include product filter as param...
     * Returns: ArrayList of products objects
     */
    private fun getProductList(): ArrayList<String> {
        val productList = ArrayList<String>()
        val itemCount = 15 // Find size of product data
        for (i in 1..itemCount){
            productList.add("$i")

            /** Shagan for Nicolle (?)
             * The code for adding the product objects
             * Please initialize and add from the dB
             */
        }
        return productList
    }

    private fun getCategoryList(): ArrayList<String> {
        val categoryList = ArrayList<String>()
        val itemCount = 10 // Find size of product data
        for (i in 1..itemCount){
            categoryList.add("$i")

            /** Shagan for Nicolle (?)
             * The code for adding the product objects
             * Please initialize and add from the dB
             */
        }
        return categoryList
    }

}