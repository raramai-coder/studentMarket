package com.example.studentmarket.ui

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.studentmarket.CategoryPage
import com.example.studentmarket.MyStorePage
import com.example.studentmarket.R
import com.example.studentmarket.RegisterStore
import com.example.studentmarket.adapters.CardAdapter
import com.example.studentmarket.adapters.ProductStoreSellerAdapter
import kotlinx.android.synthetic.main.fragment_account.*
import kotlinx.android.synthetic.main.fragment_store_seller.*


class account : Fragment() {

    private lateinit var viewModel: SavedViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_account, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        myStore_cv_acn.setOnClickListener {
            //getStore(6)

            val intent = Intent(activity, RegisterStore::class.java)
            //var bundle = Bundle()
            //bundle.putParcelable("category", categories[position])
            //intent.putExtra("categoryBundle", bundle)
            startActivity(intent)
        }

    //region old code
    /* viewModel = ViewModelProvider(this).get(SavedViewModel::class.java)

        recycler_view_store_products.layoutManager = LinearLayoutManager(activity)

//        var product_list = getProductList()
        recycler_view_store_products.adapter = ProductStoreSellerAdapter(getProductList())*/
    //endregion
    }

    private fun getStore(userID: Int){

    }


    //region Top Bar Menu
   /* override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.navigation_top_bar, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_add_product -> Toast.makeText(activity, "TODO: Add New Product Activity", Toast.LENGTH_SHORT).show()
            R.id.nav_add_preferences -> Toast.makeText(activity, "TODO: Account Preferences Activity", Toast.LENGTH_SHORT).show()
            R.id.nav_add_payment_info -> Toast.makeText(activity, "TODO: Payment Gateway Configurations", Toast.LENGTH_SHORT).show()
            R.id.nav_order_history -> Toast.makeText(activity, "TODO: Order History Activity", Toast.LENGTH_SHORT).show()

        }

        return super.onOptionsItemSelected(item)
    }*/
    //endregion Top Bar Menu

}

//region RecyclerView Functions
/*private fun getCategoryList() : ArrayList<Int> {
    val categoryList = ArrayList<Int>()
    val itemCount = 3

    for (i in 1..itemCount){
        categoryList.add(i)
    }
    return categoryList
}*/

//private fun getProductList() : ArrayList<Int>{
//
//}


/*
private fun getProductList() : ArrayList<ArrayList<String>>{

    var arrayOne = arrayListOf<String>("image/upload/33978045._SX318__xallxf", "Elementary Linear Algebra","900","4.6","Save")
    var arrayProductImages = arrayListOf<String>( "image/upload/33978045._SX318__xallxf", "image/upload/66fb1cd1110bdd98b11260afe799b478_ea4k6f", "image/upload/image_wqz1eu" , "image/upload/MTH603-Numerical-Analysis-Master-of-Computer-Science-VU-University-Past-Papers-2005-Final-Term-Exam-Fall_xlfml8" )
    var arrayProductNames = arrayListOf<String>("Elementary Linear Algebra","Stat2015 Notes","Math2028 Notes","CAM 1015 - Mechanics")
    var arrayProductPrices = arrayListOf<String>("900", "300", "250.00" , "150.00")
    var arrayProductRatings = arrayListOf<String>( "4.6", "4.3", "4.7" , "5.0")
    var arrayProductSaveds = arrayListOf<String>("Save", "Unsave", "Unsave", "Save")

    val productList = ArrayList<ArrayList<String>>()
    val itemCount =3

    for (i in 1..itemCount){
        var myArray = arrayListOf<String>(arrayProductImages[i],arrayProductNames[i], arrayProductPrices[i], arrayProductRatings[i], arrayProductSaveds[i]  )
        productList.add( myArray )
    }

    return productList
}
*/

//endregion RecyclerView Functions
