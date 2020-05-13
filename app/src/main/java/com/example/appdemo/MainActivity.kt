package com.example.appdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.appdemo.database.UserDatabase
import com.example.appdemo.database.model.User
import com.example.appdemo.database.model.UserWS
import com.example.appdemo.databinding.ActivityMainBinding
import com.example.appdemo.repository.Repository
import com.example.appdemo.viewmodel.MyViewModel
import com.example.appdemo.viewmodel.SubscriberViewModelFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var myViewModel: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val dao = UserDatabase.getInstance(application).userDAO
        val factory = SubscriberViewModelFactory(Repository(dao))

        myViewModel = ViewModelProvider(this, factory).get(MyViewModel::class.java)
        binding.myViewModel = myViewModel
        binding.lifecycleOwner = this

        CoroutineScope(Dispatchers.IO).launch {
            myViewModel.insertUser(User("Body", 1, "Title", 1))
        }
    }
}
