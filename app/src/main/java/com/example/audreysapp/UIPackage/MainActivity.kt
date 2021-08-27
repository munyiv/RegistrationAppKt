package com.example.audreysapp.UIPackage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.activity.viewModels
import com.example.audreysapp.Api.ApiClient
import com.example.audreysapp.Api.ApiInterface
import com.example.audreysapp.LoginActivity
import com.example.audreysapp.ViewModel.UserViewModel
import com.example.audreysapp.databinding.ActivityMainBinding
import com.example.audreysapp.models.RegistartionResponse
import com.example.audreysapp.models.RegistrationRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val userViewModel:UserViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupSpinner()
        clickRegister()

    }
    override fun onResume(){
        super.onResume()
        userViewModel.registrationLiveData.observe(this,{lrgResponse ->
            Toast.makeText(baseContext, "Registration Success", Toast.LENGTH_LONG).show()

        })
        userViewModel.errorLiveData.observe(this,{ error ->
            Toast.makeText(baseContext,error,Toast.LENGTH_LONG).show()
        })
    }
    fun setupSpinner(){

        var nationality= arrayOf("Select Nationality","Kenyan","Ugandan","Rwandesee","Other")
        var nationalitiesAdapter= ArrayAdapter(baseContext,android.R.layout.simple_spinner_item,nationality)
        nationalitiesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spnnationality.adapter=nationalitiesAdapter

    }

    fun clickRegister(){
        binding.btnRegister.setOnClickListener {
            var intent =Intent(baseContext, LoginActivity::class.java)
            startActivity(intent)
        }
        var error = false
        binding.btnNext.setOnClickListener {
            var name = binding.etname.text.toString()
            if (name.isEmpty()){
                error= true
                binding.etname.setError("This field is required")
            }
            var dob = binding.etDOB.text.toString()
            if (dob.isEmpty()){
                error=true
                binding.etDOB.setError("this field is required")
            }
            var email=binding.etEmail.text.toString()
            if (email.isEmpty()){
                error=true
                binding.etEmail.setError("this field is required")
            }
            var phoneNumber=binding.etPhone.text.toString()
            if (phoneNumber.isEmpty()){
                error=true
                binding.etPhone.setError("this field is required")
            }
            var password =binding.etPassword.text.toString()
            if (password.isEmpty()){
                error=true
                binding.etPassword.setError("This field is required")
            }
            var nation =binding.spnnationality.selectedItem.toString()
            if (nation.isEmpty()){
                error=true
            }

            if (!error){
                binding.pbRegistration.visibility=View.VISIBLE
                var lrqRequest = RegistrationRequest(
                    name=name,
                    phoneNumber=phoneNumber,
                    email=email,
                    dateOfBirth = dob,
                    password = password,
                    nationality = nation


                )
                userViewModel.registerStudent(lrqRequest)


            }
        }
    }
}


