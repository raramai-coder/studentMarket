package com.example.studentmarket.ui

import android.os.Bundle
import android.telecom.Call
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.za.mtn.academy.itsgotime.core.api.RetrofitClient
import com.example.studentmarket.R
import com.example.studentmarket.adapters.OrderAdapter
import com.example.studentmarket.core.api.APIService
import com.example.studentmarket.core.models.Order
import retrofit2.Response
import javax.security.auth.callback.Callback

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

/**
 * A simple [Fragment] subclass.
 * Use the [cart.newInstance] factory method to
 * create an instance of this fragment.
 */
class cart : Fragment() {

    private var orders: List<Order> = mutableListOf()
    private val apiService: APIService by lazy { RetrofitClient.apiService }
    private lateinit var orderItemsRecyclerView: RecyclerView
    private lateinit var adapter: OrderAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //TODO delete onCreate method if its not being called
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cart, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //link RecyclerView
        orderItemsRecyclerView = view.findViewById(R.id.orderItems_RCV_cart) as RecyclerView

        //create a layout manager
        orderItemsRecyclerView.layoutManager = LinearLayoutManager(activity)

        //fetch data from database
        fetchOrders()


    }


    private fun fetchOrders() {

        apiService.getOrders().enqueue(object : Callback<List<Order>!>! {

            fun onResponse(call: Call<List<Order>>?, response: Response<List<Order>>) {
                if (response.isSuccessful) {
                    //Log.i(TAG, "facilitators loaded from API $response")

                    response.body()?.let {
                        orders = it
                    }

                    if (orders.isNotEmpty())
                    //setupRecyclerView(facilitators)
                    else
                    //toast("No Items Found")

                } else {
                    //Log.i(TAG, "error $response")
                    //showErrorMessage(response.errorBody()!!)
                }
            }

            fun onFailure(call: Call<List<Order>>?, t: Throwable) {
                //toast(t.message ?: "Error Fetching Results")
            }
        })
    }
}


//val apiService: APIService by lazy { RetrofitClient.apiService }
/* apiService.getOrders().enqueue(object : Callback<List<Order>!>! {

     override fun onResponse(call: Call<List<Order>>?, response: Response<List<Order>>) {
         if (response.isSuccessful) {
             //Log.i(TAG, "facilitators loaded from API $response")

             response.body()?.let {
                 orders = it
             }

             if (orders.isNotEmpty())
             //setupRecyclerView(facilitators)
             else
             //toast("No Items Found")

         } else {
             //Log.i(TAG, "error $response")
             //showErrorMessage(response.errorBody()!!)
         }
     }

     override fun onFailure(call: Call<List<Order>>?, t: Throwable) {
         //toast(t.message ?: "Error Fetching Results")
     }
 })*/