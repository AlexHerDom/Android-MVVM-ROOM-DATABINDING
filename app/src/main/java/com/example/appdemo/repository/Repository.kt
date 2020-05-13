package com.example.appdemo.repository

import androidx.lifecycle.MutableLiveData
import androidx.room.CoroutinesRoom
import com.example.appdemo.database.dao.UserDao
import com.example.appdemo.database.model.User
import com.example.appdemo.database.model.UserWS
import com.example.appdemo.net.ApiService
import com.example.appdemo.net.Request
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository(private val dao: UserDao) {
    val userWS = MutableLiveData<List<UserWS>>()
    val userDB = dao.getAllUsers()

    fun getUsersWS() {
        val request = Request.buildService(ApiService::class.java)
        val call = request.getUsers()

        call.enqueue(object : Callback<List<UserWS>> {
            override fun onFailure(call: Call<List<UserWS>>, t: Throwable) {
                print("")
            }

            override fun onResponse(call: Call<List<UserWS>>, response: Response<List<UserWS>>) {
                userWS.value = response.body()
            }
        })
    }

    fun insertUser(user: User) {
        dao.insertUser(user)
    }
}