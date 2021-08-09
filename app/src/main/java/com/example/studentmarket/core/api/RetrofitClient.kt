package co.za.mtn.academy.itsgotime.core.api

import com.example.studentmarket.core.api.APIService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    //Base url of our server, we will use this with all the network calls that we will make.
    private val BASE_URL = "https://studentmarketapp.herokuapp.com/"

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService: APIService = retrofit.create(APIService::class.java)
}