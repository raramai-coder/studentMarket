package com.example.studentmarket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.za.mtn.academy.itsgotime.core.api.RetrofitClient
import com.example.studentmarket.adapters.CardAdapter
import com.example.studentmarket.core.api.APIService
import com.example.studentmarket.core.models.Category
import com.example.studentmarket.core.models.Product
import com.example.studentmarket.ui.home
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_category_page.*
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CategoryPage : AppCompatActivity() {

    companion object{
        private const val TAG = ""
    }

    private  val apiService: APIService by lazy { RetrofitClient.apiService }
    private var products : List<Product> = mutableListOf()
    private lateinit var prodAdapter: CardAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_page)

        supportActionBar?.hide()

        val bundle = intent.getBundleExtra("categoryBundle")
        val category = bundle!!.getParcelable<Category>("category") as Category

        recyclerView = findViewById<RecyclerView>(R.id.recycler_view_categoryPage)

        recyclerView.layoutManager = LinearLayoutManager(this)

        val categoryName = findViewById<TextView>(R.id.categoryName_txt_cp)
        categoryName.text = category.categoryName

        fetchProductsInCategory(category.categoryID)

        Snackbar.make(recyclerView,category.categoryID.toString(),Snackbar.LENGTH_LONG)
            .setAction("Action", null)
            .show()
    }


    private  fun fetchProductsInCategory(categoryID: Int){

        apiService.getProductsInCategory(categoryID).enqueue(object : Callback<List<Product>> {    //calling the api service and telling to specifically call the query in the getProductsInCategory function, which is declared in the APIService class

            override fun onResponse(call: Call<List<Product>>?, response: Response<List<Product>>) {
                if (response.isSuccessful) {
                    Log.i(TAG, "products loaded from API $response")

                    response.body()?.let {
                        products = it                               //find the products in the response and make them populate this list called products
                    }

                    if (products.isNotEmpty())
                        setupRecyclerView(products)       //furthermore if there are items in the products table then set up the recyclerview with them
                    else
                        Toast.makeText(this@CategoryPage, "No Products to Show in Category", Toast.LENGTH_SHORT).show()


                } else {
                    Log.i(TAG, "error $response")
                    //showErrorMessage(response.errorBody()!!)
                }
            }

            override fun onFailure(call: Call<List<Product>>?, t: Throwable) {
                Toast.makeText(this@CategoryPage, t.message?:"Error Fetching Results", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun setupRecyclerView(products: List<Product>) {     //this function attaches the adapter to the recyclerview and populates it with the data collected from the database
        prodAdapter = CardAdapter(products)
        recyclerView.adapter = prodAdapter

        prodAdapter.setOnButtonClickListener(object : CardAdapter.onProductClickListener{
            override fun viewProduct(position: Int) {
                val intent = Intent(this@CategoryPage, ProductPage::class.java)
                var bundle = Bundle()
                bundle.putParcelable("product", products[position])
                intent.putExtra("productBundle", bundle)
                startActivity(intent)
            }

            override fun viewStore(position: Int) {
                val intent = Intent(this@CategoryPage, Store::class.java)
                //intent.putExtra("product", products[position])
                startActivity(intent)
            }

        })


    }
}