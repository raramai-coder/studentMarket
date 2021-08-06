package com.example.studentmarket.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.studentmarket.R
import kotlinx.android.synthetic.main.widget_category.view.*


class CategoryAdapter( val items: ArrayList<String>) :
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    /**
     * Inflates the item views in the designated xml layout file
     * create a new ViewHolder and initializes some private fields to be used by RecyclerView.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.widget_category, parent,false)
        )
    }
    /**
     * Binds each item in the ArrayList to a view.
     * Called when RecyclerView needs a new ViewHolder of the given type to represent an item.
     */
    override fun onBindViewHolder(holder: CategoryAdapter.ViewHolder, position: Int) {
        val item_position = items.get(position)
//
        holder.bCategoryButton.text = "Category $item_position"
        // holder.bCategoryButton.onClick
    }

    override fun getItemCount(): Int {
        return items.size
    }
    /**
     * A ViewHolder describes an item view and metadata about it's place within the RecyclerView.
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        //Holds the data needed for each item
        val bCategoryButton = view.button_category
    }

}