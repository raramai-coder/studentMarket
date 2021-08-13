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

class ProductStoreSellerAdapter(val items: ArrayList<ArrayList<String>>) :
    RecyclerView.Adapter<ProductStoreSellerAdapter.ViewHolder>() {
    var product_list = getProductList()

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
//        var arrayProductUpdateButtons = arrayListOf<>(, , , )
//        var arrayProductDeleteButtons = arrayListOf<>(, , , )


        val product_image = product_list[position][0]
        val product_name = product_list[position][1]
        val product_price = product_list[position][2]
        val product_rating = product_list[position][3]
        val product_saved = product_list[position][4]

//        holder.ivProductImage.setImageResource("image/upload/33978045._SX318__xallxf")
        holder.etProductName.hint = product_name
        holder.etProductPrice.hint = product_price
        holder.tvProductRating.text = product_rating
        holder.tvProductSaved.text = product_saved
//        holder.btnProductUpdate.setOnClickListener()
//        holder.btnProductDelete.setOnClickListener()
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



private fun getProductList() : ArrayList<ArrayList<String>> {

    var arrayOne = arrayListOf<String>(
        "image/upload/33978045._SX318__xallxf",
        "Elementary Linear Algebra",
        "900",
        "4.6",
        "Save"
    )
    var arrayProductImages = arrayListOf<String>(
        "image/upload/33978045._SX318__xallxf",
        "image/upload/66fb1cd1110bdd98b11260afe799b478_ea4k6f",
        "image/upload/image_wqz1eu",
        "image/upload/MTH603-Numerical-Analysis-Master-of-Computer-Science-VU-University-Past-Papers-2005-Final-Term-Exam-Fall_xlfml8"
    )
    var arrayProductNames = arrayListOf<String>(
        "Elementary Linear Algebra",
        "Stat2015 Notes",
        "Math2028 Notes",
        "CAM 1015 - Mechanics"
    )
    var arrayProductPrices = arrayListOf<String>(
        "R900",
        "R300",
        "R250.00",
        "R150.00"
    )
    var arrayProductRatings = arrayListOf<String>(
        "4.6",
        "4.3",
        "4.7",
        "5.0"
    )
    var arrayProductSaveds = arrayListOf<String>(
        "Save",
        "Unsave",
        "Unsave",
        "Save"
    )

    val productList = ArrayList<ArrayList<String>>()
    val itemCount = 3

    for (i in 1..itemCount) {
        var myArray = arrayListOf<String>(
            arrayProductImages[i],
            arrayProductNames[i],
            arrayProductPrices[i],
            arrayProductRatings[i],
            arrayProductSaveds[i]
        )
        productList.add(myArray)
    }

    return productList
}