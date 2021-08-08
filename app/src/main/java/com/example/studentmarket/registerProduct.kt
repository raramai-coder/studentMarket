package com.example.studentmarket

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class registerProduct : Fragment() {


    //Not sure on purpose of these
    companion object {
        fun newInstance() = registerProduct()
    }

    private lateinit var viewModel: RegisterProductViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_register_market_item, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(RegisterProductViewModel::class.java)
        // TODO: Use the ViewModel
    }

}