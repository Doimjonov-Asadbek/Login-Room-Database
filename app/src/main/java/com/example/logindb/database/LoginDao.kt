package com.example.logindb.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface LoginDao {
    @Insert
    suspend fun insert(details:Details)

    @Query("SELECT * FROM login_details ORDER BY user_id")
    fun getAllData():Flow<List<Details>>

    @Query("SELECT * FROM login_details WHERE user_name LIKE :name")
    suspend fun getUserName(name:String?):Details?

   @Query("SELECT * FROM login_details WHERE user_name LIKE :name")
   suspend fun getUserDetails(name:String?):Details?

}