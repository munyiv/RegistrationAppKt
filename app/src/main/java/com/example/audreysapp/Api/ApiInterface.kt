package com.example.audreysapp.Api

import android.telecom.Call
import com.example.audreysapp.models.LoginRequest
import com.example.audreysapp.models.RegistartionResponse
import com.example.audreysapp.models.RegistrationRequest
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
    @POST("/student/register")
    fun registerStudent(@Body registrationRequest: RegistrationRequest): retrofit2.Call<RegistartionResponse>
    @POST("/students/register")
    fun logInStudent(@Body loginRequest: LoginRequest):retrofit2.Call<LoginRequest>
}
