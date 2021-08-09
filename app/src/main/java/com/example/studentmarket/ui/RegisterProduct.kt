package com.example.studentmarket.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.widget.Spinner
import android.widget.TextView
import android.widget.ArrayAdapter
import android.widget.AdapterView
import com.example.studentmarket.R
import kotlinx.android.synthetic.main.fragment_register_market_item.*
import org.w3c.dom.Text

class RegisterProduct : Fragment() {


    //Not sure on purpose of these
    companion object {
        fun newInstance() = RegisterProduct()
    }

    private lateinit var viewModel: RegisterProductViewModel
    lateinit var option : Spinner
    lateinit var result : TextView

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

        option = spinner_set_collection as Spinner
        result = textview_spinner_set_collection as TextView

        val options = arrayOf("Product", "Service")

//        option.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, options)

//        option.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
//            override fun onNothingSelected(parent: AdapterView<*>?) {
//                result.text = "Please select an option"
//            }
//
//            override fun onItemSelected(
//                parent: AdapterView<*>?,
//                view: View?,
//                position: Int,
//                id: Long
//            ) {
//                result.text = options.get(position)
//            }
//        }
    }

}