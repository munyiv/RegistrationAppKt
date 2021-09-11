package com.example.audreysapp.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.audreysapp.Repository.CourseRepository
import com.example.audreysapp.models.Courses
import kotlinx.coroutines.launch

class CoursesViewModel: ViewModel() {

    var coursesRepository = CourseRepository()
    var coursesLiveData = MutableLiveData<Courses>()
    var errorLiveData = MutableLiveData<String>()

    //    fun getCourses(accessToken:String){
//        var response= coursesRepository
//    }
    fun getCourses(accessToken: String) {
        viewModelScope.launch {
            var response = coursesRepository.fetchCourse(accessToken)
            if (response.isSuccessful) {
                coursesLiveData.postValue(response.body())
            } else {
                errorLiveData.postValue(response.errorBody()?.string())
            }


        }
    }
}