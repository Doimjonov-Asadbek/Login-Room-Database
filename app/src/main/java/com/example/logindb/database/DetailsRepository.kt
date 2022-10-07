package com.example.logindb.database

import kotlinx.coroutines.flow.Flow

class DetailsRepository(private val dao:LoginDao) {
    fun getAllData():Flow<List<Details>>{
        return dao.getAllData()
    }
    suspend fun insert(user:Details){
        return dao.insert(user)
    }
    suspend fun getUserName(userName:String?):Details?{
        return dao.getUserName(userName)
    }
    suspend fun getUserName1(name:String?):Details?{
        return dao.getUserDetails(name)
    }
}