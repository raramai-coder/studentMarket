package com.example.studentmarket.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import androidx.recyclerview.widget.RecyclerView
import com.example.studentmarket.R
import kotlinx.android.synthetic.main.fragment_location_listitem.view.*

class LocationSpotAdapter(val items: ArrayList<String>) :
        RecyclerView.Adapter<LocationSpotAdapter.ViewHolder>() {

        /**
         * Inflates the item views in the designated xml layout file
         * create a new ViewHolder and initializes some private fields to be used by RecyclerView.
         */
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) :
                LocationSpotAdapter.ViewHolder {
                return ViewHolder(
                        LayoutInflater.from(parent.context).inflate(R.layout.fragment_location_listitem, parent, false)
                )
        }

        override fun getItemCount(): Int {
                return items.size
        }

        override fun onBindViewHolder(holder: LocationSpotAdapter.ViewHolder, position: Int) {
                val item_position = items.get(position)
                holder.tvLocationName.text = "Knockando Residence $item_position"
                holder.tvLocationNeighborhood.text = "East Parktown"
        }


        /**
         * A ViewHolder describes the item view and meta data about its index in List*/
        class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
                val tvLocationName = view.textview_location_name
                val tvLocationNeighborhood = view.textview_location_neighborhood
        }

}