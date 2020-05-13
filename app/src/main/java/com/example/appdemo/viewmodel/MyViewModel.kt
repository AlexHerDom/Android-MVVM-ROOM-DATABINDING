package com.example.appdemo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.appdemo.database.model.User
import com.example.appdemo.repository.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyViewModel(val repository: Repository) : ViewModel() {

    val userWS = repository.userWS
    val userDB = repository.userDB

    fun insertUser(user: User) {
        repository.insertUser(user)
    }

    fun getUsersFromWS() {
        repository.getUsersWS()
    }

    fun getUsersFromDB() {
        repository.userDB
    }
}