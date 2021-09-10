package com.example.audreysapp.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.audreysapp.Repository.CourseRepository
import com.example.audreysapp.models.Courses

class CoursesViewModel: ViewModel() {

    var coursesRepository= CourseRepository()
    var coursesLiveData=MutableLiveData<Courses>()
    var errorLiveData = MutableLiveData<String>()

    fun getCourses(accessToken:String){
        var response= coursesRepository
    }
}