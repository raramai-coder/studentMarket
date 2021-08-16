package com.example.studentmarket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import co.za.mtn.academy.itsgotime.core.api.RetrofitClient
import com.example.studentmarket.core.models.Product
import com.example.studentmarket.core.models.Store
import kotlinx.android.synthetic.main.activity_register_store.*
import java.util.ArrayList
import com.cloudinary.*
import com.example.studentmarket.classes.User
import com.example.studentmarket.core.api.APIService
import com.example.studentmarket.ui.saved
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_saved.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterStore : AppCompatActivity() {

    companion object {
        private const val TAG = ""
    }

    var config: HashMap<String, String> = HashMap()
    private val apiService: APIService by lazy { RetrofitClient.apiService }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_store)
        supportActionBar?.hide()

        val cloudinary = Cloudinary("cloudinary://953935929942593:McqSMr6CXiQnTMZi6MPjFTDIpfw@hb9ogjlea")

        cloudinary.image {
            publicId("sample")
        }
        supportActionBar?.hide()

        val registerStore_btn = findViewById<Button>(R.id.registerStore_btn_rgs)

        registerStore_btn.setOnClickListener {
            val storeName = storeName_et_rgs.text.toString()
            val storeDescription = storeDescription_etM_rgs.text.toString()

            var deliveryOptions: MutableList<Int> = ArrayList()
            var storeCategories: IntArray = IntArray(2)

            storeCategories.plus(1)

            //todo code for getting image and uploading
            val storePicture: String

            //region delivery chips
            val deliverToBuyer = deliverToBuyer_chip_rgs
            deliverToBuyer.setOnClickListener {
                deliveryOptions.add(4)
            }

            val buyercanCollect = buyerCanCollect_chip_rgs
            buyercanCollect.setOnClickListener {
                deliveryOptions.add(5)
            }

            val paxiStandard = paxiStandard_chip_rgs
            paxiStandard.setOnClickListener {
                deliveryOptions.add(2)
            }

            val paxiLarge = paxiLarge_chip_rgs
            paxiLarge.setOnClickListener {
                deliveryOptions.add(3)
            }

            val aramex = amarex_chip_rgs
            aramex.setOnClickListener {
                deliveryOptions.add(1)
            }

            val mainCampus = mainCampus_chip_rgs
            mainCampus.setOnClickListener {
                deliveryOptions.add(6)
            }

            val junction = junction_chip_rgs
            junction.setOnClickListener {
                deliveryOptions.add(7)
            }

            val education = deducation_chip_rgs
            education.setOnClickListener {
                deliveryOptions.add(8)
            }

            val eoh = eoh_chip_rgs
            eoh.setOnClickListener {
                deliveryOptions.add(9)
            }
            //endregion

            //deliveryOptions.toIntArray()

           val newStore = Store(1,storeName,deliveryOptions.toIntArray(),null,0f,0,storeCategories,storeDescription)

            apiService.registerStore(newStore).enqueue(object: Callback<Store> {
                override fun onResponse(call: Call<Store>, response: Response<Store>) {
                    Log.i(TAG, "products loaded from API $response")


                    Snackbar.make(registerStore_btn, "Store created, We will reach out when your store is Live", Snackbar.LENGTH_LONG)
                        .setAction("Action", null)
                        .show()
                }

                override fun onFailure(call: Call<Store>, t: Throwable) {
                    Toast.makeText(this@RegisterStore, t.message?:"Error Fetching Results", Toast.LENGTH_SHORT).show()
                }

            })


        }
    }


}