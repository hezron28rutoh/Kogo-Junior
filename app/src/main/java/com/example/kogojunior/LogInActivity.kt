package com.example.kogojunior

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import com.example.kogojunior.admin.AdminActivity
import com.example.kogojunior.databinding.ActivityLoginBinding
import com.example.kogojunior.ui.DashboardActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth

class LogInActivity : AppCompatActivity() {

    private lateinit var firebaseAuth: FirebaseAuth
    lateinit var edtEmailLogin:TextInputEditText
    lateinit var edtPasswordLogin:TextInputEditText
    lateinit var tvToRegister:TextView
    lateinit var button:AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        edtEmailLogin = findViewById(R.id.edtEmailLogin)
        edtPasswordLogin = findViewById(R.id.edtPasswordLogin)
        tvToRegister = findViewById(R.id.tvToRegister)
        button = findViewById(R.id.button)
        firebaseAuth = FirebaseAuth.getInstance()
        tvToRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
        button.setOnClickListener {
            val email = edtEmailLogin.text.toString()
            val pass = edtPasswordLogin.text.toString()
            if(email.isNotEmpty() && pass.isNotEmpty()) {
                if (email == "admin@gmail" && pass == "admin...") {
                    val intent = Intent(this, AdminActivity::class.java)
                    startActivity(intent)
                    Toast.makeText(this, "Admin Logged in...", Toast.LENGTH_SHORT).show()


                } else {
                    firebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener {
                        if (it.isSuccessful) {
                            val intent = Intent(this, DashboardActivity::class.java)
                            startActivity(intent)
                        } else {
                            Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }else {
                Toast.makeText(this, "Empty Fields Are not Allowed !!", Toast.LENGTH_SHORT).show()
            }
        }
    }

}
