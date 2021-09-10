package com.example.audreysapp.UIPackage

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.audreysapp.Constants
import com.example.audreysapp.CourcesRvAdapter
import com.example.audreysapp.R
import com.example.audreysapp.ViewModel.CoursesViewModel
import com.example.audreysapp.databinding.ActivityLoginBinding
import com.example.audreysapp.databinding.ActivityMunyivaBinding
import com.example.audreysapp.models.Courses
//class CoursesActivity : AppCompatActivity() {
//    lateinit var binding: ActivityCourseBinding
//    val courseViewModel: CourseViewModel by viewModels()
//    lateinit var sharedPrefs: SharedPreferences
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        binding= ActivityCourseBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//        sharedPrefs= getSharedPreferences(Constants.REGISTRATION_PREFS, Context.MODE_PRIVATE)
//        var accessToken = sharedPrefs.getString(Constants.ACCESS_TOKEN, Constants.EMPTY_STRING)!!
//        if (accessToken.isNotEmpty())
//            courseViewModel.getCourses(accessToken)
//    }


class MunyivaActivity : AppCompatActivity() {
    lateinit var binding: ActivityMunyivaBinding
    val coursesViewModel:CoursesViewModel by viewModels()
    lateinit var  sharedPrefs:SharedPreferences
//    lateinit var rvCourses: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMunyivaBinding.inflate(layoutInflater)
        setContentView(binding.root)
    sharedPrefs=getSharedPreferences(Constants.REGISTRATION_PREFS,Context.MODE_PRIVATE)
    var accesToken=sharedPrefs.getString(Constants.ACCESS_TOKEN,Constants.EMPTY_STRING)!!
    if(accesToken.isNotEmpty())
        coursesViewModel.getCourses(accesToken)
        display()

    }
    fun display(){
        var coursesList= listOf<Courses>(
            Courses("Android","Mobile101","Introduction to Mobile development","John Owour"),
            Courses("JavaScript","JavaScript102","Introduction to Web development","Purity"),
            Courses("Android","Mobile101","Introduction to Mobile development","John Owour"),
            Courses("Android","Mobile101","Introduction to Mobile development","John Owour"),
            Courses("Android","Mobile101","Introduction to Mobile development","John Owour"),
            Courses("JavaScript","JavaScript102","Introduction to Web development","Purity"),
            Courses("Android","Mobile101","Introduction to Mobile development","John Owour"),
            Courses("Android","Mobile101","Introduction to Mobile development","John Owour"),
            Courses("Android","Mobile101","Introduction to Mobile development","John Owour")
        )
        var courcesRvAdapter=CourcesRvAdapter(coursesList)
        binding.rvCources.layoutManager=LinearLayoutManager(baseContext)
        binding.rvCources.adapter=courcesRvAdapter

        Toast.makeText(this, "fetched ${coursesList.size} courses", Toast.LENGTH_LONG).show()




    }
}