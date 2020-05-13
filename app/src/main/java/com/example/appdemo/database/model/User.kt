package com.example.appdemo.database.model

import androidx.databinding.Bindable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @ColumnInfo(name = "body_user")
    val body: String,

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "title_user")
    val title: String,

    @ColumnInfo(name = "id_user")
    val userId: Int
)

data class UserWS(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
)