package com.example.audreysapp.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.audreysapp.Repository.UserRepository
import com.example.audreysapp.UIPackage.LoginRequest
import com.example.audreysapp.models.LoginResponse
import com.example.audreysapp.models.RegistartionResponse
import com.example.audreysapp.models.RegistrationRequest
import kotlinx.coroutines.launch

class UserViewModel:ViewModel() {
    var userRespository=UserRepository()
    var registrationLiveData=MutableLiveData<RegistartionResponse>()
    var errorLiveData= MutableLiveData<String>()
    var loginLiveData=MutableLiveData<LoginResponse>()


    fun registerStudent(registrationRequest: RegistrationRequest){
        viewModelScope.launch {
            var response= userRespository.registerStudent(registrationRequest)
            if (response.isSuccessful){
                registrationLiveData.postValue(response.body())
            }else{
                errorLiveData.postValue(response.errorBody()?.string())
            }


        }
    }
    fun loginStudent(loginRequest: LoginRequest){
        viewModelScope.launch {
            var response= userRespository.loginStudent(loginRequest)
            if (response.isSuccessful){
                loginLiveData.postValue(response.body())
            }else{
                errorLiveData.postValue(response.errorBody()?.string())
            }


        }
    }

}
