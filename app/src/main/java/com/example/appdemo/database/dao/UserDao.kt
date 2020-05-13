package com.example.appdemo.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.appdemo.database.model.User

@Dao
interface UserDao {
    @Query("SELECT * FROM users")
    fun getAllUsers(): LiveData<List<User>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: User): Long
}