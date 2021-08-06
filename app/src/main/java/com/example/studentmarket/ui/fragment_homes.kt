package com.example.studentmarket.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.studentmarket.R
import kotlinx.android.synthetic.main.fragment_home.*
import androidx.lifecycle.ViewModelProvider

/**
 * A simple [Fragment] subclass.
 * Use the [home.newInstance] factory method to
 * create an instance of this fragment.
 */

class fragment_homes : Fragment() {

    companion object {
        fun newInstance() = fragment_homes()
    }

    private lateinit var viewModel: FragmentHomesViewModel

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FragmentHomesViewModel::class.java)
        // TODO: Use the ViewModel
    }

}