package com.example.studentmarket.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_saved.*
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.studentmarket.adapters.CardAdapter
import com.example.studentmarket.R
import java.util.*

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

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    companion object {
        fun newInstance() = search()
    }

    private lateinit var viewModel: SearchViewModel

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
        recycler_view_products.layoutManager = LinearLayoutManager(activity)
//        recycler_view_categories.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)

        //Recycler_view_items' adapter component is set to ContactAdapter. Contact list is sent using func
        recycler_view_products.adapter = CardAdapter(getSearchList())
//        recycler_view_categories.adapter = CategoryAdapter(getSearchCategoryList())
    }
    private fun getSearchList(): ArrayList<String> {
        val SearchList = ArrayList<String>()
        val itemCount = 30 // Find size of product data
        for (i in 1..itemCount){
            SearchList.add("$i")

            /** Shagan for Nicolle (?)
             * The code for adding the product objects
             * Please initialize and add from the dB
             */
        }
        return SearchList
    }

    /** Not Important
     * Supposed to allow for filtering categories
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

//    SHAGAN: OLD___Found below function commented out here
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        arguments?.let {
//            param1 = it.getString(ARG_PARAM1)
//            param2 = it.getString(ARG_PARAM2)
//        }
//    }

}