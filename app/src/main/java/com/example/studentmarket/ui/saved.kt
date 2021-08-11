package com.example.studentmarket.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.studentmarket.R
import kotlinx.android.synthetic.main.fragment_saved.*
import java.util.*

class saved : Fragment() {

    companion object {
        fun newInstance() = saved()
    }

    private lateinit var viewModel: SavedViewModel

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
        //recycler_view_products.adapter = CardAdapter(getSavedList())
//        recycler_view_categories.adapter = CategoryAdapter(getCategoryList())
    }
    private fun getSavedList(): ArrayList<String> {
        val SavedList = ArrayList<String>()
        val itemCount = 5 // Find size of product data
        for (i in 1..itemCount){
            SavedList.add("$i")

            /** Shagan for Nicolle (?)
             * The code for adding the product objects
             * Please initialize and add from the dB
             */
        }
        return SavedList
    }

    /** Not Important
     *
     */
    private fun getSavedCategoryList(): ArrayList<String> {
        val savedCategoryList = ArrayList<String>()
        val itemCount = 10 // Find size of product data
        for (i in 1..itemCount) {
            savedCategoryList.add("$i")

            /**
             * Not IMPORTANT.
             */
        }
        return savedCategoryList
    }

}