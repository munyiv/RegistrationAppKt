package com.example.audreysapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MunyivaActivity : AppCompatActivity() {
    lateinit var rvCourses: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_munyiva)
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
        rvCourses=findViewById(R.id.rvCources)
        var coursesAdapter=CourcesRvAdapter(coursesList)
        rvCourses.layoutManager=LinearLayoutManager(baseContext)
        rvCourses.adapter=coursesAdapter


    }
}