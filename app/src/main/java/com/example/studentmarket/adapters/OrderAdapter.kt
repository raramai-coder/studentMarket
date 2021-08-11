package com.example.studentmarket.adapters

import androidx.recyclerview.widget.RecyclerView
import com.example.studentmarket.core.models.Order
import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater
import android.widget.TextView
import com.example.studentmarket.R


class OrderAdapter(val order: List<Order>) : RecyclerView.Adapter<OrderAdapter.ViewHolder>(){

    var onItemClick:((Order) -> Unit)? = null

    //this method is returning the view for each item in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.fragment_cartitem,parent,false)
        return ViewHolder(v)
    }

    //this method is binding the data on the list
    override fun onBindViewHolder(holder: OrderAdapter.ViewHolder, position: Int) {
        holder.bindItems(order[position])
    }

    //this method is returning the size of the list
    override fun getItemCount(): Int {
        return order.size
    }

    //the class is holding the listview
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        //execute
        init {
            itemView.setOnClickListener{
                onItemClick?.invoke(order[adapterPosition])
            }
        }

        fun bindItems(order: Order){
            val nameAmountText = itemView.findViewById(R.id.textview_cartitem_name) as TextView
            val orderTotalText = itemView.findViewById(R.id.textview_cartitem_price) as TextView

            val cartTotal = itemView.findViewById<TextView>(R.id.textview_cart_total)

            var orderTotal:Float = order.orderAmount * order.unitPrice

            nameAmountText.text = order.orderAmount.toString()+ " x " + order.prodName
            orderTotalText.text = "R" + orderTotal.toString() +"0"
        }
    }


}