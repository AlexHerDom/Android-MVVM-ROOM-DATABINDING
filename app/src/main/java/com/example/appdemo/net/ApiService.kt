package com.example.appdemo.net

import com.example.appdemo.database.model.UserWS
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("posts")
    fun getUsers(): Call<List<UserWS>>
}