package com.example.audreysapp

import com.google.gson.annotations.SerializedName

data class EnrollementRequest(
    @SerializedName("student_id") var student_id:String,
    @SerializedName("course_id") var course_id: String
)
