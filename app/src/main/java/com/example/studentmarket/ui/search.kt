package com.example.studentmarket.ui

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import co.za.mtn.academy.itsgotime.core.api.RetrofitClient
import com.example.studentmarket.ProductPage
import com.example.studentmarket.adapters.CardAdapter
import com.example.studentmarket.R
import com.example.studentmarket.Store
import com.example.studentmarket.core.api.APIService
import com.example.studentmarket.core.models.Product
import kotlinx.android.synthetic.main.fragment_saved.recycler_view_store_products
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [search.newInstance] factory method to
 * create an instance of this fragment.
 */

class search : Fragment() {

    companion object {
        fun newInstance() = search()
        private const val TAG = ""
    }

    private lateinit var viewModel: SearchViewModel
    private val apiService: APIService by lazy { RetrofitClient.apiService }
    private var products: List<Product> = mutableListOf()
    private lateinit var prodAdapter: CardAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SearchViewModel::class.java)
        // TODO: Use the ViewModel

        // Recycler_view_items' layout manager component is set to LinearLayoutManager instance. This instance of Main activity is context
        recycler_view_store_products.layoutManager = LinearLayoutManager(activity)
//        recycler_view_categories.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)

        fetchProducts()
        //Recycler_view_items' adapter component is set to ContactAdapter. Contact list is sent using func
        //recycler_view_products.adapter = CardAdapter(getSearchList())
//        recycler_view_categories.adapter = CategoryAdapter(getSearchCategoryList())
    }

    private fun fetchProducts() {

        apiService.getProducts().enqueue(object : Callback<List<Product>> {

            override fun onResponse(call: Call<List<Product>>?, response: Response<List<Product>>) {
                if (response.isSuccessful) {
                    Log.i(TAG, "products loaded from API $response")

                    response.body()?.let {
                        products = it
                    }

                    if (products.isNotEmpty())
                        setupRecyclerView(products)
                    else
                        Toast.makeText(activity, "No Products to Show", Toast.LENGTH_SHORT).show()


                } else {
                    Log.i(TAG, "error $response")
                    //showErrorMessage(response.errorBody()!!)
                }
            }

            override fun onFailure(call: Call<List<Product>>?, t: Throwable) {
                Toast.makeText(activity, t.message?:"Error Fetching Results", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun setupRecyclerView(products: List<Product>) {
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

            override fun saveProduct(product: Product) {
                saved.user1.AddSave(product)
            }

        })

    }



    //region old code
    /*private fun getSearchList(): ArrayList<String> {
        val SearchList = ArrayList<String>()
        val itemCount = 30 // Find size of product data
        for (i in 1..itemCount){
            SearchList.add("$i")

            *//** Shagan for Nicolle (?)
             * The code for adding the product objects
             * Please initialize and add from the dB
             *//*
        }
        return SearchList
    }

    *//** Not Important
     * Supposed to allow for filtering categories
     *//*
    private fun getSavedCategoryList(): ArrayList<String> {
        val savedCategoryList = ArrayList<String>()
        val itemCount = 10 // Find size of product data
        for (i in 1..itemCount) {
            savedCategoryList.add("$i")

            *//**
             * Not IMPORTANT.
             *//*
        }
        return savedCategoryList
    }

//    SHAGAN: OLD___Found below function commented out here
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        arguments?.let {
//            param1 = it.getString(ARG_PARAM1)
//            param2 = it.getString(ARG_PARAM2)
//        }
//    }*/
    //endregion

}