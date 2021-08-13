package com.example.studentmarket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import co.za.mtn.academy.itsgotime.core.api.RetrofitClient
import com.example.studentmarket.core.api.APIService
import com.example.studentmarket.core.models.Category
import com.example.studentmarket.core.models.Product
import com.example.studentmarket.core.models.Store
import com.example.studentmarket.core.models.User
import com.example.studentmarket.ui.home
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_store.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StorePage : AppCompatActivity() {

    companion object{
        private const val TAG = ""
    }

    private val apiService: APIService by lazy { RetrofitClient.apiService }
    private var stores: List<Store> = mutableListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store)

        supportActionBar?.hide()

        val storeName = findViewById<TextView>(R.id.textview_store_name)

        val bundle = intent.getBundleExtra("userBundle")
        val storeOwner = bundle!!.getInt("userID")


       /* Snackbar.make(storeName,storeOwner.toString(),Snackbar.LENGTH_LONG)
           .setAction("Action", null)
           .show()*/

        getStore(storeOwner)
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
    }

}