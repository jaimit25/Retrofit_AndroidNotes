package com.example.retro

import com.google.gson.Gson
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.retro.Models.EmailModel
import com.example.retro.Models.UserCredentials
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.example.retro.Models.UserModel



class MainActivity : AppCompatActivity() {

    private lateinit var list : ListView




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        list = findViewById(R.id.listview)

        init()
    }

    fun init(){
        val retrofit = Retrofit.Builder()
            .baseUrl("https://personal-api.up.railway.app/api/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val apiService = retrofit.create(MyApiService::class.java)
                doProcessing(apiService)
    }

//    fun doProcessing(apiService: MyApiService) {
//        apiService.getUsers().enqueue(object : Callback<List<UserModel>> {
//            override fun onResponse(call: Call<List<UserModel>>, response: Response<List<UserModel>>) {
//                if (response.isSuccessful) {
//                    val jsonResponse = response.body()?.toJsonString()
//                    Log.d("API Response", "JSON Response: $jsonResponse")
//                } else {
//                    // Handle error
//                    Log.e("API Error", "Error: ${response.code()}")
//                }
//            }
//
//            override fun onFailure(call: Call<List<UserModel>>, t: Throwable) {
//                // Handle failure
//                Log.e("API Failure", "Error: ${t.message}")
//            }
//        })
//    }

    fun doProcessing(apiService: MyApiService) {
        val email = EmailModel(email = "email@gmail.com")
        val credentials = UserCredentials(email = "email@gmail.com", password = "password123")
        val user = UserModel(id = 123, email = "email@gmail.com", password = "password123", ip = "192.168.29.129", phone = "+91 21801213011")
        val userId = 123

        // Get Users
        val getUsersCall = apiService.getUsers()
        getUsersCall.enqueue(object : Callback<List<UserModel>> {
            override fun onResponse(call: Call<List<UserModel>>, response: Response<List<UserModel>>) {
                if (response.isSuccessful) {
                    val users = response.body()
                    // Process the list of users
                    val jsonResponse = response.body()?.toJsonString()
                    Log.d("API Response", "JSON Response: $jsonResponse")
                } else {
                    // Handle error
                }
            }

            override fun onFailure(call: Call<List<UserModel>>, t: Throwable) {
                // Handle failure
            }
        })

        // Get User by Email - ERROR
//        val getUserByEmailCall = apiService.getUserByEmail(email)
//        getUserByEmailCall.enqueue(object : Callback<UserModel> {
//            override fun onResponse(call: Call<UserModel>, response: Response<UserModel>) {
//                if (response.isSuccessful) {
//                    val user = response.body()
//                    // Process the user data
//                } else {
//                    // Handle error
//                }
//            }
//
//            override fun onFailure(call: Call<UserModel>, t: Throwable) {
//                // Handle failure
//            }
//        })

        // Check User
        val checkUserCall = apiService.checkUser(credentials)
        checkUserCall.enqueue(object : Callback<UserModel> {
            override fun onResponse(call: Call<UserModel>, response: Response<UserModel>) {
                if (response.isSuccessful) {
                    val user = response.body()
                    // Process the user data
                } else {
                    // Handle error
                }
            }

            override fun onFailure(call: Call<UserModel>, t: Throwable) {
                // Handle failure
            }
        })

        // Add User
        val addUserCall = apiService.addUser(user)
        addUserCall.enqueue(object : Callback<UserModel> {
            override fun onResponse(call: Call<UserModel>, response: Response<UserModel>) {
                if (response.isSuccessful) {
                    val user = response.body()
                    // User added successfully
                } else {
                    // Handle error
                }
            }

            override fun onFailure(call: Call<UserModel>, t: Throwable) {
                // Handle failure
            }
        })

        // Delete User
//        val deleteUserCall = apiService.deleteUser(userId)
//        deleteUserCall.enqueue(object : Callback<Void> {
//            override fun onResponse(call: Call<Void>, response: Response<Void>) {
//                if (response.isSuccessful) {
//                    // User deleted successfully
//                } else {
//                    // Handle error
//                }
//            }
//
//            override fun onFailure(call: Call<Void>, t: Throwable) {
//                // Handle failure
//            }
//        })

        // Update User
//        val updateUserCall = apiService.updateUser(user)
//        updateUserCall.enqueue(object : Callback<UserModel> {
//            override fun onResponse(call: Call<UserModel>, response: Response<UserModel>) {
//                if (response.isSuccessful) {
//                    val user = response.body()
//                    // User updated successfully
//                } else {
//                    // Handle error
//                }
//            }
//
//            override fun onFailure(call: Call<UserModel>, t: Throwable) {
//                // Handle failure
//            }
//        })
    }



    fun Any?.toJsonString(): String {
        return Gson().toJson(this)
    }


}