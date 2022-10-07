package com.example.logindb.viewmodel

import android.app.Application
import android.util.Patterns
import androidx.lifecycle.*
import com.example.logindb.database.Details
import com.example.logindb.database.DetailsRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.lang.NullPointerException

class RegisterViewModel(private val repository: DetailsRepository):
    ViewModel() {

    val name=MutableLiveData<String>()

    val email=MutableLiveData<String>()

    val phone=MutableLiveData<String>()

    val password=MutableLiveData<String>()

    val confirmPassword=MutableLiveData<String>()

    private val navigation=MutableLiveData<Boolean>()

    private val errorMsg=MutableLiveData<Boolean>()

   private val mailerror=MutableLiveData<Boolean>()

    private val passwordError=MutableLiveData<Boolean>()

    private val numberError=MutableLiveData<Boolean>()

    private val count=MutableLiveData<Boolean>()

     val check=MutableLiveData<Boolean>()

    private val checkError=MutableLiveData<Boolean>()

    private val special=MutableLiveData<Boolean>()


    val _passwordError:LiveData<Boolean>
     get() = passwordError

    val _navigation: LiveData<Boolean>
      get() = navigation


    val _errorMsg:LiveData<Boolean>
    get() = errorMsg

    val _numberError:LiveData<Boolean>
     get() = numberError

     val _count:LiveData<Boolean>
       get() = count

    val _check:LiveData<Boolean>
        get() = checkError

    val _special:LiveData<Boolean>
        get() = special


val _errorMail:LiveData<Boolean>
 get() = mailerror

     fun submitButton(){
         if(name.value==null && email.value==null && phone.value==null &&  password.value==null){
             errorMsg.value=true
         }else {
             viewModelScope.launch {
                 try {
                     val getName = name.value!!
                     val getMail = email.value!!
                     val getPhone = phone.value!!
                     val getPassword = password.value!!
                     val getcheckbox=check.value!!
                     when {
                         !Patterns.EMAIL_ADDRESS.matcher(getMail).matches()->
                             mailerror.value=true
                         !Patterns.PHONE.matcher(getPhone).matches() ->
                             numberError.value = true
                         getPassword.length < 8 ->
                              count.value=true
                         getcheckbox==false ->
                             checkError.value=true
                         getPassword != confirmPassword.value ->
                             passwordError.value = true
                         else->{
                             insert(Details(0, getName, getMail, getPhone, getPassword))
                             clearData()
                             navigation.value = true
                         }
                     }
                 }catch (exception:NullPointerException){
                     errorMsg.value=true
                     checkError.value=true
                     navigation.value=false
                 }
             }
         }
         }

   private fun insert(details: Details):Job=
        viewModelScope.launch {
            repository.insert(details)
        }
    fun setNavigation(){
        navigation.value=false
    }
   private fun clearData(){
        name.value=null
        email.value=null
        phone.value=null
        password.value=null
    }
    fun error(){
        errorMsg.value=false
    }
    fun checkMail(){
        mailerror.value=false
    }
    fun checkPhone(){
        numberError.value=false
    }
    fun checkPassword(){
        passwordError.value=false
    }
}


