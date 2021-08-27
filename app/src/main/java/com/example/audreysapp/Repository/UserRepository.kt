package com.example.audreysapp.Repository

import com.example.audreysapp.Api.ApiClient
import com.example.audreysapp.Api.ApiInterface
import com.example.audreysapp.UIPackage.LoginRequest
import com.example.audreysapp.models.LoginResponse
import com.example.audreysapp.models.RegistartionResponse
import com.example.audreysapp.models.RegistrationRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class UserRepository {
    var retrofit=ApiClient.buildApiClient(ApiInterface::class.java)

    suspend fun registerStudent(registrationRequest: RegistrationRequest):Response<RegistartionResponse> =
        withContext(Dispatchers.IO){
            var response=retrofit.registerStudent(registrationRequest)
            return@withContext response

        }
    suspend fun loginStudent(loginRequest: LoginRequest): Response<LoginRequest> =
        withContext(Dispatchers.IO){
            var request=retrofit.logInStudent(loginRequest)
            return@withContext request
        }


}