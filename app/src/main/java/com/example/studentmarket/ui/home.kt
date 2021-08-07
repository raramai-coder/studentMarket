package com.example.studentmarket.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.studentmarket.R
import kotlinx.android.synthetic.main.fragment_home.*
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.studentmarket.adapters.CategoryAdapter
import com.example.studentmarket.adapters.CardAdapter
import androidx.lifecycle.ViewModelProvider
import java.util.*

/**
 * A simple [Fragment] subclass.
 * Use the [home.newInstance] factory method to
 * create an instance of this fragment.
 */

class home : Fragment() {

    companion object {
        fun newInstance() = home()
    }

    private lateinit var viewModel: homeViewModel

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
        recycler_view_products.adapter = CardAdapter(getProductList())
        recycler_view_categories.adapter = CategoryAdapter(getCategoryList())
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