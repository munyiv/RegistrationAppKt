package com.example.audreysapp.Api

import com.example.audreysapp.EnrollmentResponse
import com.example.audreysapp.UIPackage.LoginRequest
import com.example.audreysapp.models.Courses
import com.example.audreysapp.models.RegistartionResponse
import com.example.audreysapp.models.RegistrationRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiInterface {
    @POST("/student/register")
    suspend fun registerStudent(@Body registrationRequest: RegistrationRequest): retrofit2.Response<RegistartionResponse>
    @POST("/students/register")
    suspend fun logInStudent(@Body loginRequest: LoginRequest):retrofit2.Response<LoginRequest>
    @GET("/courses")
    suspend fun fetchCourses(@Header("Authorization")token:String):Response<List<Courses>>
    @POST("/enrolments")
    suspend fun enrol(@Header("Authorization")token: String):Response<EnrollmentResponse>
}
