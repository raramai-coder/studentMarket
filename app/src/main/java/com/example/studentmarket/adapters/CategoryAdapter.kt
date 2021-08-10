package com.example.studentmarket.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.studentmarket.R
import com.example.studentmarket.core.models.Category
import kotlinx.android.synthetic.main.widget_category.view.*
import org.w3c.dom.Text


class CategoryAdapter( val categories: List<Category>) :
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    //a listener for when the Category Button is pressed
    private lateinit var mListener: onCategoryClickListener

    //an interface that is called in the home activity, and its functions are implemented there,
    // that is where the code for opening the category page is written
    interface onCategoryClickListener{
        fun viewCategory(position: Int)
    }

    //this function attaches the buttons to the listener returned when the viewholder is created
    fun setOnButtonClickListener(listener: onCategoryClickListener){
        mListener = listener
    }

    /**
     * Inflates the item views in the designated xml layout file
     * create a new ViewHolder and initializes some private fields to be used by RecyclerView.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.widget_category, parent,false),
            mListener
        )
    }
    /**
     * Binds each item in the ArrayList to a view.
     * Called when RecyclerView needs a new ViewHolder of the given type to represent an item.
     */
    override fun onBindViewHolder(holder: CategoryAdapter.ViewHolder, position: Int) {
        //val item_position = items.get(position)
        holder.bindItems(categories[position])
        //holder.bCategoryButton.text = "Category $item_position"
        // holder.bCategoryButton.onClick
    }

    override fun getItemCount(): Int {
        return categories.size
    }
    /**
     * A ViewHolder describes an item view and metadata about it's place within the RecyclerView.
     */
    inner class ViewHolder(view: View, listener: onCategoryClickListener) : RecyclerView.ViewHolder(view){
        //Holds the data needed for each item


        fun bindItems(category: Category){
            val categoryName = itemView.findViewById(R.id.category_txt_home) as TextView

            categoryName.text = category.categoryName
        }

        //this initializes for when the category is clicked it will open the category page
        init {
            itemView.setOnClickListener {
                listener.viewCategory(adapterPosition)
            }
        }
    }

}