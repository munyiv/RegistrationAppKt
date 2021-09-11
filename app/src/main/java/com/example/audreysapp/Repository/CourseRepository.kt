package com.example.audreysapp.Repository

import com.example.audreysapp.Api.ApiClient
import com.example.audreysapp.Api.ApiInterface
import com.example.audreysapp.EnrollmentResponse
import com.example.audreysapp.models.Courses
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class  CourseRepository {
    var retrofit= ApiClient.buildApiClient(ApiInterface::class.java)

    suspend fun fetchCourse(accessToken:String):Response<List<Courses>> =
        withContext(Dispatchers.IO){
            return@withContext retrofit.fetchCourses(accessToken)
        }
    suspend fun enrol(accessToken: String): Response<EnrollmentResponse> =
        withContext(Dispatchers.IO){
            var enrol =ApiInterface.enrol(accessToken)
            return@withContext enrol
        }

    }

