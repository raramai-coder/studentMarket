package com.example.studentmarket.classes

import com.example.studentmarket.core.models.Product

class Store (name:String, type:String){

    var storeName = name
    val storeType = type
    var storeItems = ArrayList<Product>()

    init {
        //TODO add the store to the database
    }

    fun AddItemToSaved(product : Product){
        //TODO create the process for how an item is added to the store
        storeItems.add(product)

    }


}