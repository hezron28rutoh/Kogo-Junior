package com.example.kogojunior

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.kogojunior.databinding.ActivityRegisterBinding
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {

    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var edtEmailReg:TextInputEditText
    private lateinit var edtPasswordReg:TextInputEditText
    private lateinit var edtConfirmPassReg:TextInputEditText
    private lateinit var button:Button
    private lateinit var tvtoLogin:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        edtEmailReg = findViewById(R.id.edtEmailReg)
        edtPasswordReg = findViewById(R.id.edtPasswordReg)
        edtConfirmPassReg = findViewById(R.id.edtConfirmPassReg)
        button = findViewById(R.id.button)
        tvtoLogin = findViewById(R.id.tvtoLogin)

        firebaseAuth = FirebaseAuth.getInstance()

        tvtoLogin.setOnClickListener {
            val toLogin = Intent(this, LogInActivity::class.java)
            startActivity(toLogin)
        }
        button.setOnClickListener {
            val email = edtEmailReg.text.toString()
            val pass = edtPasswordReg.text.toString()
            val confirmPass = edtConfirmPassReg.text.toString()

            if (email.isNotEmpty() && pass.isNotEmpty() && confirmPass.isNotEmpty()) {
                if (pass == confirmPass) {
                    firebaseAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener {
                        if (it.isSuccessful) {
                            val toAddStudentDetails = Intent(this, StudentsProfileActivity::class.java)
                            startActivity(toAddStudentDetails)
                        } else {
                            Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                        }
                    }
                } else {
                    Toast.makeText(this, "Password is not matching", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Empty Fields Are not Allowed !!", Toast.LENGTH_SHORT).show()

            }
        }

    }
}