
package com.example.studentmarket.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.studentmarket.R
import kotlinx.android.synthetic.main.fragment_home.view.*


class CardAdapter(val context: Context, val items: ArrayList<String>) :
    RecyclerView.Adapter<CardAdapter.ViewHolder>() {

    /**
     * Inflates the item views in the designated xml layout file
     * create a new
     * {@link ViewHolder} and initializes some private fields to be used by RecyclerView.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.widget_product_card, parent,false)

        )
    }

    /**
     * Binds each item in the ArrayList to a view.
     *
     * Called when RecyclerView needs a new {@link ViewHolder} of the given type to represent an item.
     */
    override fun onBindViewHolder(holder: CardAdapter.ViewHolder, position: Int) {
        val item_position = items.get(position)
        var prodName = "Product number: $item_position"
        holder.tvProductName.text = prodName
        holder.tvProductPrice.text = "R 1$item_position.99"
        holder.tvRating.text = "4.9 ($item_position)"
        holder.tvLocation.text = "1.$item_positon km away"
        holder.tvSaved.text = "Save"
        holder.bViewStore.OnClick = "Not sure how this section will work"
        holder.bViewProduct.OnClick = "Not sure how this section will work"

    //        //Updating bg color according to odd/even positions in list
//        if (position %2 ==0){
//            holder.cardViewContact.setBackgroundColor(
//                ContextCompat.getColor( activity, R.color.colorLightGray)
//            )
//        } else{
//            holder.cardViewContact.setBackgroundColor(
//                ContextCompat.getColor(context, R.color.colorWhite)
//            )
//        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
    /**
     * A ViewHolder describes an item view and metadata about it's place within the RecyclerView.
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        //Holds the data needed to add to each item
        val tvProductName = view.text_view_product_name
        val ivProductImage = view.text_view_product_price
        val tvProductPrice = view.text_view_rating

        //        val ivRating = view.image_view_rating
        val tvRating = view.text_view_rating
        val tvLocation = view.text_view_location
        //        val ivSaved = view.image_view_saved
        val tvSaved = view.text_view_saved

        val bViewStore = view.button_view_store
        val bViewProduct = view.button_view_product
    }

}