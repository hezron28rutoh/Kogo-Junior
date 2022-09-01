package com.example.kogojunior

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.kogojunior.databinding.ActivityStudentsProfileBinding
import com.example.kogojunior.ui.DashboardActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class StudentsProfileActivity : AppCompatActivity() {

    private lateinit var stdAdmno:TextInputEditText
    private lateinit var stdNameDetails:TextInputEditText
    private lateinit var classDetail:TextInputEditText
    private lateinit var stdDOB:TextInputEditText
    private lateinit var parent1Name:TextInputEditText
    private lateinit var parent1Email:TextInputEditText
    private lateinit var parent1Phone:TextInputEditText
    private lateinit var parent2Name:TextInputEditText
    private lateinit var parent2Email:TextInputEditText
    private lateinit var parent2Phone:TextInputEditText
    private lateinit var btnSaveAndContinue:Button
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_students_profile)

        stdAdmno = findViewById(R.id.stdAdmno)
        stdNameDetails = findViewById(R.id.stdNameDetails)
        classDetail = findViewById(R.id.classDetail)
        stdDOB = findViewById(R.id.stdDOB)
        parent1Name = findViewById(R.id.parent1Name)
        parent1Email = findViewById(R.id.parent1Email)
        parent1Phone = findViewById(R.id.parent1Phone)
        parent2Name = findViewById(R.id.parent2Name)
        parent2Email = findViewById(R.id.parent2Email)
        parent2Phone = findViewById(R.id.parent2Phone)
        btnSaveAndContinue = findViewById(R.id.btnSaveAndContinue)


        btnSaveAndContinue.setOnClickListener {
            val studentsName = stdNameDetails.text.toString()
            val stdAdmNo = stdAdmno.text.toString()
            val stdClass = classDetail.text.toString()
            val stdDOB = stdDOB.text.toString()
            val parentName = parent1Name.text.toString()
            val parentEmail = parent1Email.text.toString()
            val parentPhone = parent1Phone.text.toString()
            val parentSecName = parent2Name.text.toString()
            val parentSecEmail = parent2Email.text.toString()
            val parentSecPhone = parent2Phone.text.toString()
//            check if the fields are empty


            database = FirebaseDatabase.getInstance().getReference("Students")
            val Student = Student(studentsName, stdAdmNo, stdClass, stdDOB, parentName,parentEmail,parentPhone,parentSecName,parentSecEmail,parentSecPhone)
            database.child(stdAdmNo).setValue(Student).addOnSuccessListener {
                stdNameDetails.text!!.clear()
                stdAdmno.text!!.clear()
                classDetail.text!!.clear()
//                stdDOB.text!!.clear()
                parent1Name.text!!.clear()
                parent1Email.text!!.clear()
                parent1Phone.text!!.clear()
                parent2Name.text!!.clear()
                parent2Email.text!!.clear()
                parent2Phone.text!!.clear()

                val toHome = Intent(this, DashboardActivity::class.java)
                startActivity(toHome)

                Toast.makeText(this,"Data Successfully Saved !!", Toast.LENGTH_LONG).show()

            }.addOnFailureListener {
                Toast.makeText(this,"Sorry!!Data Failed to save", Toast.LENGTH_LONG).show()
            }
        }

    }
}