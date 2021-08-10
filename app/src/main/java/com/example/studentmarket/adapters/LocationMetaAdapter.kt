package com.example.studentmarket.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import androidx.recyclerview.widget.RecyclerView
import com.example.studentmarket.R
import kotlinx.android.synthetic.main.fragment_location_meta.view.*

class LocationMetaAdapter(val items: ArrayList<String>) :
        RecyclerView.Adapter<LocationMetaAdapter.ViewHolder>() {

    /**
     * Inflates the item views in the designated xml layout file
     * create a new ViewHolder and initializes some private fields to be used by RecyclerView.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) :
            LocationMetaAdapter.ViewHolder {
        return ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.fragment_location_meta, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: LocationMetaAdapter.ViewHolder, position: Int) {
        val item_position = items.get(position)
        holder.ivLocationMeta.setImageResource(R.drawable.welcome_2)
        holder.tvLocationMeta.text = "Security Level $item_position"
        // holder.cvLocationMeta.setCardBackgroundColor()
    }


    /**
     * A ViewHolder describes the item view and meta data about its index in List*/
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvLocationMeta = view.textview_location_meta
        val ivLocationMeta = view.image_view_location_meta
        val cvLocationMeta = view.cardview_location_meta
    }

}