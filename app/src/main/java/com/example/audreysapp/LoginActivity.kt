package com.example.audreysapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.example.audreysapp.Api.ApiClient
import com.example.audreysapp.Api.ApiInterface
import com.example.audreysapp.databinding.ActivityLoginBinding
import com.example.audreysapp.UIPackage.LoginRequest
import com.example.audreysapp.UIPackage.MunyivaActivity
import com.example.audreysapp.ViewModel.UserViewModel
import com.example.audreysapp.models.LoginResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    lateinit var sharedPrefs:SharedPreferences
    val userViewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        logInStudent()

    }
    override fun onResume(){
        super.onResume()
        userViewModel.loginLiveData.observe(this,{lrgResponse ->
            var accesToken=lrgResponse.accesToken
            accesToken="Bearer $accesToken"
            var editor =sharedPrefs.edit()
            editor.putString(Constants.STUDENT_ID,lrgResponse.studentId)
            editor.apply()
            sharedPrefs.edit().putString(Constants.ACCESS_TOKEN,accesToken).apply()

            Toast.makeText(baseContext, "Registration Success", Toast.LENGTH_LONG).show()
            startActivity(Intent(baseContext,MunyivaActivity::class.java))
        })
        userViewModel.errorLiveData.observe(this,{ error ->
            Toast.makeText(baseContext,error,Toast.LENGTH_LONG).show()
        })
    }

    fun logInStudent(){
        var error=false
        binding.btnToast.setOnClickListener {

            var email = binding.tilemail.text.toString()
            if (email.isEmpty() || email.isBlank()){
                error=true
                binding.tilemail1.setError("This field is required")
            }

            var password = binding.tvPassword.text.toString()
            if (password.isEmpty()){
                error=true
                binding.tilPassword.setError("This field is required")
            }
            if(!error){
                binding.btnToast.visibility=View.GONE
                var lrgRequest= LoginRequest(
                    email =email,
                    password = password
                )
                userViewModel.loginStudent(lrgRequest)

            }

        }

    }

}





