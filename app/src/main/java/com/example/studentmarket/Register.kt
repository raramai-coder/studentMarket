package com.example.studentmarket

import android.graphics.Color
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.text.method.LinkMovementMethod
import android.util.Log
import android.widget.Toast
import co.za.mtn.academy.itsgotime.core.api.RetrofitClient
import com.example.studentmarket.core.api.APIService
import com.example.studentmarket.core.models.User
import com.example.studentmarket.ui.home
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.content_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Register : AppCompatActivity() {
    companion object{
        private const val TAG = "register"
    }

    private val apiService: APIService by lazy { RetrofitClient.apiService }
    private lateinit var user : User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        setUpHyperlink()
        //region Register Button
        val register_btn = findViewById<Button>(R.id.register_btn_rg)

        //when you click this button it opens up the main activity
        register_btn.setOnClickListener {

            if(TermsCondition_checkBox_rg.isChecked && privacyPolicy_checkBox_rg.isChecked){
                 val inputUserName = username_et_rg.text.toString()
                 val inputEmail = email_et_rg.text.toString()
                 val inputUniversity = university_et_rg.text.toString()
                 val inputPassword = password_et_rg.text.toString()

                val newUser = User(1,inputUserName,inputEmail,inputUniversity,inputPassword,)

                 registerUser(newUser)

             }else{
                 Snackbar.make(register_btn, "Accept Terms and Conditions and Privacy Policy", Snackbar.LENGTH_LONG)
                     .setAction("Action", null)
                     .show()
             }

            /*val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)*/
        }
        //endregion
    }

    private fun registerUser(newUser: User){

        apiService.registerUser(newUser).enqueue(object:
            Callback<User>{
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if(response.isSuccessful){
                    Log.i(TAG, "user loaded from API $response")

                    response.body()?.let {
                        user = it                              //find the products in the response and make them populate this list called products
                    }
                    home.userID = user.userID
                    val intent = Intent(this@Register,MainActivity::class.java)
                    startActivity(intent)

                }else{
                    Log.i(TAG, "error $response")
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                Toast.makeText(this@Register, t.message?:"Error Registering User", Toast.LENGTH_SHORT).show()
            }

        })
    }

    fun setUpHyperlink() {
        val linkPrivacy = findViewById<TextView>(R.id.textview_terms_conditions)
        val linkTermsConditions = findViewById<TextView>(R.id.textview_privacy_policy)
//        val linkTextView = findViewByID<TextView>(R.id.fragment_privacy_popup)
        linkPrivacy.setMovementMethod(LinkMovementMethod.getInstance())
        linkTermsConditions.setMovementMethod(LinkMovementMethod.getInstance())
        linkPrivacy.setLinkTextColor(Color.BLUE)
        linkTermsConditions.setLinkTextColor(Color.BLUE)
    }
}