package com.example.kogojunior.admin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.kogojunior.R
import com.example.kogojunior.Student
import com.example.kogojunior.ui.DashboardActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class AddStaffActivity : AppCompatActivity() {
    private lateinit var fullname: TextInputEditText
    private lateinit var phonenumber: TextInputEditText
    private lateinit var idnumber: TextInputEditText
    private lateinit var email: TextInputEditText
    private lateinit var position: TextInputEditText
    private lateinit var submit: Button
    private lateinit var database: DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_staff)

        fullname = findViewById(R.id.userName)
        phonenumber = findViewById(R.id.MobileNo)
        idnumber = findViewById(R.id.dataBirth)
        email = findViewById(R.id.email)
        position = findViewById(R.id.info)
        submit = findViewById(R.id.addInfo)

        submit.setOnClickListener {
            val username = fullname.text.toString()
            val phone = phonenumber.text.toString()
            val emailaddress = email.text.toString()
            val idno = idnumber.text.toString()
            val rank = position.text.toString()
            database = FirebaseDatabase.getInstance().getReference("Staff")
            val Staff = Staff(username, phone, emailaddress, idno, rank)
            database.child(username).setValue(Staff).addOnSuccessListener {
                fullname.text!!.clear()
                phonenumber.text!!.clear()
                email.text!!.clear()
                idnumber.text!!.clear()
                position.text!!.clear()


                val toHome = Intent(this, DashboardActivity::class.java)
                startActivity(toHome)

                Toast.makeText(this,"Data Successfully Saved !!", Toast.LENGTH_LONG).show()
            }
        }


    }
}