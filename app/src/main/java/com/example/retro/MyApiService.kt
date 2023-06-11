
package com.example.retro

import com.example.retro.Models.EmailModel
import com.example.retro.Models.UserCredentials
import com.example.retro.Models.UserModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.*


interface MyApiService {

    @GET("users")
    fun getUsers(): Call<List<UserModel>>

    @GET("user")
    fun getUserByEmail(@Body emailData: EmailModel): Call<UserModel>

    @POST("user/check")
    fun checkUser(@Body credentials: UserCredentials): Call<UserModel>

    @POST("user/add")
    fun addUser(@Body user: UserModel): Call<UserModel>

    @DELETE("user/delete/{id}")
    fun deleteUser(@Path("id") userId: Int): Call<Void>

    @PUT("user/update")
    fun updateUser(@Body user: UserModel): Call<UserModel>
}
