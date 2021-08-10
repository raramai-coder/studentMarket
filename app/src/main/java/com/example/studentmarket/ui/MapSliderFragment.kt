package com.example.studentmarket.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.studentmarket.R
import com.example.studentmarket.adapters.LocationMetaAdapter
import kotlinx.android.synthetic.main.fragment_location.*

class MapSliderFragment : Fragment() {
     companion object {
         fun newInstance() = MapSliderFragment()
     }
    private lateinit var viewModel: SavedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_location, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProvider(this).get(SavedViewModel::class.java)

    }

}
/**
private fun getLocationList() : ArrayList<String> {
    val locationsList = ArrayList<String>()
    val itemCount = 10

    for (i in 1..itemCount){
        locationsList.add("$i")
    }
    return locationsList
}

private fun getLocationMeta() : ArrayList<String>{

    val locationsMetaList = ArrayList<String>()
    val itemCount = 10

    for (i in 1..itemCount){
        locationsMetaList.add("$i")
    }
    return locationsMetaList
} */