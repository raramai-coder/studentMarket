package com.example.studentmarket

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_home.*
import com.example.studentmarket.adapters.CardAdapter
import java.util.*


/**
 * A simple [Fragment] subclass.
 * Use the [home.newInstance] factory method to
 * create an instance of this fragment.
 */
class home : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)

    }

    /** Shagan
     * Get Product List and return list of product objects
     * Param: None so far, can update to include product filter as param...
     * Returns: ArrayList of products objects
     */
    private fun getProductList(): ArrayList<String>{
        val productList = ArrayList<String>()
        val itemCount = 15 // Find size of product data
        for (i in 1..itemCount){
            productList.add("This is product number$i")

            /** Shagan for Nicolle (?)
             * The code for adding the product objects
             * Please initialize and add from the dB
             */
        }
        return productList
    }

}