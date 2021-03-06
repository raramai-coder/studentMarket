package com.example.studentmarket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.material.bottomsheet.*
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.fragment_location_post_order.*
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.studentmarket.adapters.LocationMetaAdapter
import com.example.studentmarket.adapters.OrderAdapter
import com.example.studentmarket.core.models.Order
import kotlinx.android.synthetic.main.fragment_cart.*
import android.widget.Button
import kotlinx.android.synthetic.main.fragment_home.*
//import com.example.studentmarket.Store

/**
 * An activity that displays a Google map with a marker (pin) to indicate a particular location.
 */
// [START maps_marker_on_map_ready]

class MapSliderActivity2 : AppCompatActivity(), OnMapReadyCallback {
    var orders: List<Order> = mutableListOf()
    private lateinit var bottomSheetBehavior: BottomSheetBehavior<ConstraintLayout>
    private lateinit var storeID : com.example.studentmarket.classes.Store
    private lateinit var orderAdapter: OrderAdapter
    public var map_location : DoubleArray = doubleArrayOf(-26.181121, 28.038017)
    // [START_EXCLUDE]
    // [START maps_marker_get_map_async]
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //region MapImplementation
        // Retrieve the content view that renders the map.
        setContentView(R.layout.fragment_location_2)

        // Get the SupportMapFragment and request notification when the map is ready to be used.
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as? SupportMapFragment
        mapFragment?.getMapAsync(this)
        //endregion MapImplementation
        //region Checkout Back To Home Button
        //TODO: Write logic to skip to map slider button AND set coordinates
        val btnMapSlider = findViewById<Button>(R.id.button_cart_checkout)
        btnMapSlider.text = "DONE"
        btnMapSlider.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
//            btn_map_slider.setTextColor("FFFFFF")
            startActivity(intent)
            finish()
        }
        //endregion Checkout Back To Home Button


        //region Bottom Sheet
        bottomSheetBehavior = BottomSheetBehavior.from(constraintlayout_location)
        bottomSheetBehavior.setHideable(true)
        bottomSheetBehavior.setPeekHeight(130)
        bottomSheetBehavior.setDraggable(false)
        /* bottomSheetBehavior.addBottomSheetCallback(object: BottomSheetBehavior.BottomSheetCallback(){
            override fun onSlide(bottomSheet: View, slideOffset: Float){

            }
            override fun onStateChanged(bottomSheet: View, newState: Int){
                button_bottom_sheet.text = when(newState){
                    BottomSheetBehavior.STATE_EXPANDED -> "Hide"
                    else -> "Show"
                }
            }
        }) */

        button_bottom_sheet.setOnClickListener{
            bottomSheetBehavior.state = if(bottomSheetBehavior.state == BottomSheetBehavior.STATE_EXPANDED)
                BottomSheetBehavior.STATE_COLLAPSED else BottomSheetBehavior.STATE_EXPANDED

        }

        //endregion Bottom Sheet

        //region Recycler Views
        /**recycler_view_cart_items.layoutManager = LinearLayoutManager(this)
        recycler_view_location_schedule.layoutManager = LinearLayoutManager(this)

        if (orders.isNotEmpty()){
            recycler_view_cart_items.adapter = OrderAdapter(orders)
        }

        recycler_view_location_schedule.adapter = LocationMetaAdapter(getLocationMeta())
        **/
        //endregion RecyclerViews


    }
    // [END maps_marker_get_map_async]
    // [END_EXCLUDE]

    // [START maps_marker_on_map_ready_add_marker]
    override fun onMapReady(googleMap: GoogleMap) {
        val sydney = LatLng(map_location[0], map_location[1])
        googleMap.addMarker(
            MarkerOptions()
                .position(sydney)
                .title("Marker in Sydney")
        )
        //region [START_EXCLUDE silent]
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
        //endregion [END_EXCLUDE]
    }
    // [END maps_marker_on_map_ready_add_marker]
}
// [END maps_marker_on_map_ready]

//region RecyclerView Functions
private fun getLocationList() : ArrayList<String> {
    val locationsList = ArrayList<String>()
    val itemCount = 4

    for (i in 1..itemCount){
        locationsList.add("$i")
    }
    return locationsList
}

private fun getLocationMeta() : ArrayList<String>{

    val locationsMetaList = ArrayList<String>()
    val itemCount = 1

    for (i in 1..itemCount){
        locationsMetaList.add("$i")
    }
    return locationsMetaList
}
private fun getCart(){
}

//endregion RecyclerView Functions