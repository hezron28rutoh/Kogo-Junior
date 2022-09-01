package com.example.kogojunior

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import com.example.kogojunior.admin.AdminActivity
import com.example.kogojunior.ui.DashboardActivity

class SchoolCalendarActivity : AppCompatActivity() {

    private lateinit var backtohome:ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_school_calendar)

        backtohome = findViewById(R.id.backtohome)

        backtohome.setOnClickListener {
            val intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
        }
    }
}