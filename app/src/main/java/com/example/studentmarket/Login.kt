package com.example.studentmarket

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import co.za.mtn.academy.itsgotime.core.api.RetrofitClient
import com.example.studentmarket.core.api.APIService
import com.example.studentmarket.core.models.User
import com.example.studentmarket.ui.home
import kotlinx.android.synthetic.main.content_login.*
import kotlinx.android.synthetic.main.fragment_saved.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Login : AppCompatActivity() {

    companion object {
        private const val TAG = "login page"
        public lateinit var currentUser: User
    }

    private  val apiService: APIService by lazy { RetrofitClient.apiService }
    private var usersReturned : List<User> = mutableListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setSupportActionBar(findViewById(R.id.toolbar))

        //region Login Button
        val login_btn = findViewById<Button>(R.id.login_btn_lg)



        //when you click this button it opens up the main activity
        login_btn.setOnClickListener {
            val inputEmail = email_et_lg.text.toString()
            val inputPassword= password_et_lg.text.toString()
            LoginUser(inputEmail,inputPassword)
        }
        //endregion

        //region Forgot Password Button
        val forgot_btn = findViewById<Button>(R.id.forgot_btn_lg) //Todo set what happens when user forgot password

        //when you click this button it changes color, will have to code later what happens when the user forgets their password
        forgot_btn.setOnClickListener {
            forgot_btn.setTextColor(getColor(R.color.primary_teal))
        }
        //endregion


    }

    private fun LoginUser(userEmail: String, userPassword: String){

        apiService.loginUser(userEmail,userPassword).enqueue(object : Callback<List<User>>{

            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                if (response.isSuccessful) {
                    Log.i(TAG, "user loaded from API $response")

                    response.body()?.let {
                        usersReturned = it                              //find the products in the response and make them populate this list called products
                    }


                    if(usersReturned.isNullOrEmpty()){

                        Snackbar.make(login_btn_lg, "Incorrect Credentials entered", Snackbar.LENGTH_LONG)
                            .setAction("Action", null)
                            .show()
                        //Log.i(TAG,usersRetruned[0].userEmail)
                        password_et_lg.text.clear()

                    }else{
                        currentUser = usersReturned[0]
                        home.userID = currentUser.userID
                        val intent = Intent(this@Login,MainActivity::class.java)
                        startActivity(intent)
                    }


                } else {
                    Log.i(TAG, "error $response")
                }
            }

            override fun onFailure(call: Call <List<User>>, t: Throwable) {
                Toast.makeText(this@Login, t.message?:"Error Fetching User Results", Toast.LENGTH_SHORT).show()
            }
        })
    }
}