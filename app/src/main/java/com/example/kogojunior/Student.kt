package com.example.kogojunior

data class Student(val studentsName:String ?= null,
                   val stdAdmNo: String ?= null,
                   val stdClass:String ?= null,
                   val stdDOB:String ?= null,
                   val parentName:String ?= null,
                   val parentEmail: String?,
                   val parentPhone:String ?= null,
                   val parentSecName:String ?= null,
                   val parentSecEmail: String?,
                   val parentSecPhone:String ?= null
)
