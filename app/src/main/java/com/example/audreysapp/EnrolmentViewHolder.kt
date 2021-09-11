package com.example.audreysapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.audreysapp.Repository.CourseRepository
import kotlinx.coroutines.launch

class EnrolmentViewHolder:ViewModel() {
    var enrolmentLiveData= MutableLiveData<EnrollmentResponse>()
    var errorLiveData=MutableLiveData<String>()
    var courseRepository =CourseRepository()

    fun enrol(accesToken:String){
        viewModelScope.launch {
            var response= courseRepository.enrol(accesToken)
            if(response.isSuccessful){
                enrolmentLiveData.postValue(response.body())
            }else{errorLiveData.postValue(response.errorBody()?.string())}
        }
    }
}


