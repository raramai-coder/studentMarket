package com.example.studentmarket.classes

/*This class is for products and services*/
class MarketItem (name:String, user:Int,price:Float,rangeOfItem:Float,category:String){

    val type: ArrayList<String> = arrayListOf("Product","Service")

    /*This function populate the product page*/
    fun ViewProduct(){
        //TODO collect the product information from the database and populate the product page


    }

    /*This function is called by the adapter and feeds it */
    fun DisplayProduct(){
        //TODO give information to the adapter for the recyclerview
    }

    /*This function calculates the distance between the user and the product
    * @params: the user's location*/
    fun FindDistance(userLocation:Float){
        //TODO calulate the distance between the product and the user, information stored in the database
    }



}