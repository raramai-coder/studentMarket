package com.example.studentmarket.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.studentmarket.R
import kotlinx.android.synthetic.main.widget_product_card.view.*


class CardAdapter( val items: ArrayList<String>) :
    RecyclerView.Adapter<CardAdapter.ViewHolder>() {


    /**
     * Inflates the item views in the designated xml layout file
     * create a new ViewHolder and initializes some private fields to be used by RecyclerView.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.widget_product_card, parent,false)
        )
    }

    /**
     * Binds each item in the ArrayList to a view.
     * Called when RecyclerView needs a new ViewHolder of the given type to represent an item.
     */
    override fun onBindViewHolder(holder: CardAdapter.ViewHolder, position: Int) {
        val item_position = items.get(position)
//        holder.ivProductImage.tools.srcCompat = "@tools:sample/backgrounds/scenic"
        holder.tvProductName.text = "Product number: $item_position"
        holder.tvProductPrice.text = "R 1$item_position.99"
        holder.tvRating.text = "4.9 ($item_position)"
        holder.tvLocation.text = "1.$item_position km away"
        holder.tvSaved.text = "Save" //TODO: Check if saved
//        holder.bViewStore.OnClick = "Not sure how this section will work yet"
//        holder.bViewProduct.OnClick = "Not sure how this section will work yet"
    }

    override fun getItemCount(): Int {
        return items.size
    }

    /**
     * A ViewHolder describes an item view and metadata about it's place within the RecyclerView.
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        //Holds the data needed for each item
        val tvProductName = view.text_view_product_name
        val ivProductImage = view.image_view_product_image //srcCompat="@tools:sample/backgrounds/scenic"
        val tvProductPrice = view.text_view_product_price

        //        val ivRating = view.image_view_rating
        val tvRating = view.text_view_rating
        val tvLocation = view.text_view_location
        //        val ivSaved = view.image_view_saved
        val tvSaved = view.text_view_saved

        val bViewStore = view.button_view_store
        val bViewProduct = view.button_view_product
    }
}
