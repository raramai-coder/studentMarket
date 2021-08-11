package com.example.studentmarket.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.studentmarket.R
import kotlinx.android.synthetic.main.fragment_store_seller.view.*
import kotlinx.android.synthetic.main.widget_product_card_store_seller.view.*

class ProductStoreSellerAdapter(val items: ArrayList<Int>) :
    RecyclerView.Adapter<ProductStoreSellerAdapter.ViewHolder>() {

    /**
     * Inflates the item views in the designated xml layout file
     * create a new ViewHolder and initializes some private fields to be used by RecyclerView.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) :
            ProductStoreSellerAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.widget_product_card_store_seller, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ProductStoreSellerAdapter.ViewHolder, position: Int) {
        val item_position = items.get(position)
        var product_list = arrayListOf<String>(
            "image/upload/33978045._SX318__xallxf",
            "Elementary Linear Algebra",
            "900",
            "4.6",
            "Save"
        )

        holder.tvProductRating.text = "4.6"

    }


    /**
     * A ViewHolder describes the item view and meta data about its index in List*/
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ivProductImage = view.image_view_product_image
        val etProductName = view.edittext_product_name
        val etProductPrice = view.edittext_product_price
        val tvProductRating = view.text_view_rating
        val tvProductSaved = view.text_view_saved
        val btnProductUpdate = view.button_update_info
        val btnProductDelete = view.button_delete_product
    }

}