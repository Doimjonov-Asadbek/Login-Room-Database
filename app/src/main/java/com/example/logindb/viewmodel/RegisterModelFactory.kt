@file:Suppress("UNCHECKED_CAST")

package com.example.logindb.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.logindb.database.DetailsRepository
import java.lang.IllegalArgumentException

class RegisterModelFactory(private val repository: DetailsRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(RegisterViewModel::class.java)){
            return RegisterViewModel(repository) as T
        }
        throw IllegalArgumentException("")
    }
}