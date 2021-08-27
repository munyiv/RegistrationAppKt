package com.example.audreysapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.example.audreysapp.Api.ApiClient
import com.example.audreysapp.Api.ApiInterface
import com.example.audreysapp.databinding.ActivityLoginBinding
import com.example.audreysapp.UIPackage.LoginRequest
import com.example.audreysapp.ViewModel.UserViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
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
            Toast.makeText(baseContext, "Registration Success", Toast.LENGTH_LONG).show()
        })
        userViewModel.errorLiveData.observe(this,{ error ->
            Toast.makeText(baseContext,error,Toast.LENGTH_LONG).show()
        })
    }

    fun logInStudent(){
        var error=false
        binding.btnToast.setOnClickListener {

            var email = binding.tilemail.text.toString()
            if (email.isEmpty()){
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




