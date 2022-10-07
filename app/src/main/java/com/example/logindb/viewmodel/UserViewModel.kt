package com.example.logindb.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.logindb.database.Details
import com.example.logindb.database.DetailsRepository
import kotlinx.coroutines.flow.Flow


class UserViewModel(repository: DetailsRepository):
    ViewModel(){

  private val getData:Flow<List<Details>> =repository.getAllData()

    val data= liveData {
        getData.collect{
            Log.i("hi","$it")
            emit(it)
        }
    }






        }




