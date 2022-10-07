package com.example.logindb.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.example.logindb.database.Details
import com.example.logindb.database.DetailsRepository
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import java.lang.NullPointerException

class LoginViewModel(private val repository: DetailsRepository):
    ViewModel() {
    val username = MutableLiveData<String>()
    val password = MutableLiveData<String>()
    private val passwordError = MutableLiveData<Boolean>()

    private val navigation = MutableLiveData<Boolean>()

    private val errmsg = MutableLiveData<Boolean>()

    val _navigation: LiveData<Boolean>
        get() = navigation

    private val singnupnavigation = MutableLiveData<Boolean>()

    val _signupnavigation: LiveData<Boolean>
        get() = singnupnavigation
    val _passwordError: LiveData<Boolean>
        get() = passwordError
    val data: String
        get() = username.value.toString()
    val _error: LiveData<Boolean>
        get() = errmsg

    fun submit() {
        if (username.value == null && password.value == null) {
            errmsg.value = true
            navigation.value = false
        } else {
            CoroutineScope(Dispatchers.IO).launch {
                val user = repository.getUserName(username.value.toString())
                Log.i("him", user.toString())
                Log.i("him", username.value.toString())
                Log.i("him", data)
                Log.i("him", "${username.value}")
                withContext(Dispatchers.Main) {
                    if (user != null) {
                        if (user.password == password.value) {
                            Log.i("him", username.value.toString())
                            navigation.value = true

                        } else {
                            passwordError.value = true
                        }
                    }
                }
            }
        }
    }


    fun signup() {
        singnupnavigation.value = true
    }

    fun setNavigation() {
        navigation.value = false
    }

    fun setSignNavigation() {
        singnupnavigation.value = false
    }

    fun setPassword() {
        passwordError.value = false
    }


            }



