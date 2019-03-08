package com.example.myapplication.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey var id: Int,
    @ColumnInfo(name = "first_name") var firstName: String,
    @ColumnInfo(name = "last_name") var lastName: String,
    @ColumnInfo(name = "age") var age: Float,
    @ColumnInfo(name = "self_introduction") var introduction: String?
) {
    fun nickName() = "${firstName.capitalize()} ${firstName.capitalize()}"
}