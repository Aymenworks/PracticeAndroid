package com.example.myapplication.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.myapplication.models.User

@Dao
interface UserDao {
    @Query("Select * from user")
    fun all() : LiveData<List<User>>

    @Query("Select * from user where id = :id")
    fun getUser(id: Int) : LiveData<User>

    @Insert
    fun insertAll(vararg users: User)

    @Delete
    fun delete(user: User)
}