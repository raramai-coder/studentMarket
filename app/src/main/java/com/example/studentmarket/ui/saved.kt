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
import com.example.studentmarket.R
import com.example.studentmarket.StorePage
import com.example.studentmarket.core.models.Store
import com.example.studentmarket.adapters.CardAdapter
import com.example.studentmarket.classes.User
import com.example.studentmarket.core.api.APIService
import com.example.studentmarket.core.models.Product
import com.example.studentmarket.core.models.Saved
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_saved.*
import kotlinx.android.synthetic.main.fragment_saved.recycler_view_store_products
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class saved : Fragment() {


    companion object {
        fun newInstance() = saved()
        private const val TAG = ""
        public val user1 : User = User("Tester",1)
    }

    private lateinit var viewModel: SavedViewModel
    private val apiService: APIService by lazy { RetrofitClient.apiService }
    private lateinit var prodAdapter: CardAdapter
    private var products: MutableList<Product> = ArrayList()
    private var savedProducts: List<Saved> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_saved, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SavedViewModel::class.java)
        // TODO: Use the ViewModel

        // Recycler_view_items' layout manager component is set to LinearLayoutManager instance. This instance of Main activity is context
        recycler_view_store_products.layoutManager = LinearLayoutManager(activity)
//        recycler_view_categories.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)

        //Recycler_view_items' adapter component is set to ContactAdapter. Contact list is sent using func
        //recycler_view_store_products.adapter = CardAdapter(getSavedList())
//        recycler_view_categories.adapter = CategoryAdapter(getCategoryList())
        //fetchProduct(1)
        fetchSavedList(home.userID)
        products.toList()
        setupRecyclerView(products)

    }

    private fun fetchSavedList(userID:Int){

        apiService.getSavedProducts(userID).enqueue(object: Callback<List<Saved>>{
            override fun onResponse(call: Call<List<Saved>>, response: Response<List<Saved>>) {
                if (response.isSuccessful){
                    Log.i(TAG, "saved products loaded from API $response")

                    response.body()?.let {
                        savedProducts = it
                    }

                    if (savedProducts.isNotEmpty()){

                        for (saved: Saved in savedProducts){
                            fetchProduct(saved.prodID)
                        }
                    }

                    /*products.toList()
                    Toast.makeText(activity, products[1].prodName, Toast.LENGTH_SHORT).show()

                    if (products.isNotEmpty()) {//

                    setupRecyclerView(products)
                    //}else
                        Toast.makeText(activity, "No Saved Products to Show", Toast.LENGTH_SHORT).show()*/
                   // var savedProducts = listOf(products).toList()
                    //products.toMutableList()
                    setupRecyclerView(products)

                }else{
                    Log.i(TAG, "error $response")
                }
            }

            override fun onFailure(call: Call<List<Saved>>, t: Throwable) {
                Toast.makeText(activity, t.message?:"Error Fetching Results", Toast.LENGTH_SHORT).show()
            }

        })

    }

    private fun fetchProduct(prodID:Int) {

            apiService.getProduct(prodID).enqueue(object : Callback<Product> {

                override fun onResponse(call: Call<Product>?, response: Response<Product>) {
                    if (response.isSuccessful) {
                        Log.i(TAG, "products loaded from API $response")

                        //val productsList = List<Product>()
                        val currentProduct : Product = response.body()!!
                        //Log.i(TAG, currentProduct.prodName)
                        //products[1] = response.body()
                        //products.add(response.body())
                        //products.toMutableList().add(currentProduct)
                       // products.plus(currentProduct)
                        //products.plusElement(currentProduct)
                        //.listIterator()
                        products.add(currentProduct)
                        //products[0].


                        Log.i(TAG, "from list " +products[0].prodName)

                        //response.body()
                        /*response.body()?.let {
                            products = it
                        }*/


                    } else {
                        Log.i(TAG, "error $response")
                        //showErrorMessage(response.errorBody()!!)
                    }
                }

                override fun onFailure(call: Call<Product>?, t: Throwable) {
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
                val intent = Intent(activity, StorePage::class.java)
                var bundle = Bundle()
                bundle.putInt("userID", products[position].user)
                intent.putExtra("userBundle", bundle)
                startActivity(intent)
            }

            override fun saveProduct(product: Product) {
                //saved.user1.AddSave(product)
                apiService.saveProduct(product).enqueue(object : Callback<Product> {    //calling the api service and telling to specifically call the query in the getProducts function, which is declared in the APIService class

                    override fun onResponse(call: Call<Product>, response: Response<Product>) {
                        if (response.isSuccessful) {
                            Log.i(TAG, "products loaded from API $response")


                            Snackbar.make(recycler_view_store_products, "Saved Product", Snackbar.LENGTH_LONG)
                                .setAction("Action", null)
                                .show()


                        } else {
                            Log.i(TAG, "error $response")
                            //showErrorMessage(response.errorBody()!!)
                        }
                    }

                    override fun onFailure(call: Call<Product>?, t: Throwable) {
                        Toast.makeText(activity, t.message?:"Error Adding to Bag", Toast.LENGTH_SHORT).show()
                    }
                })
            }


        })

    }

   //region old code
    /* private fun getSavedList(): List<Product> {
        val SavedList = user1.FetchSavedItems()
        *//*val itemCount = 5 // Find size of product data
        for (i in 1..itemCount){
            SavedList.add("$i")

            *//**//** Shagan for Nicolle (?)
             * The code for adding the product objects
             * Please initialize and add from the dB
             *//**//*
        }*//*
        return SavedList
    }

    *//** Not Important
     *
     *//*
    private fun getSavedCategoryList(): ArrayList<String> {
        val savedCategoryList = ArrayList<String>()
        val itemCount = 10 // Find size of product data
        for (i in 1..itemCount) {
            savedCategoryList.add("$i")

        }
        return savedCategoryList
    }*/
    //endregion

}