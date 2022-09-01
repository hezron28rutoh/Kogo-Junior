package com.example.kogojunior.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.cardview.widget.CardView
import com.example.kogojunior.*
import com.example.kogojunior.admin.AdminActivity

class DashboardActivity : AppCompatActivity() {
    private lateinit var tocontactUs: CardView
    private lateinit var ourStaff: CardView
    private lateinit var mGeneralInfo: CardView
    private lateinit var mSchoolCalender: CardView
    private lateinit var mSchoolServices: CardView
    private lateinit var mFeeDetails: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
//initializing General Info

        mGeneralInfo = findViewById(R.id.mGeneralInfo)
        mGeneralInfo.setOnClickListener {
            val toGenInfo = Intent(this,AdminActivity::class.java)
            startActivity(toGenInfo)
        }
//initializing School Calender
        mSchoolCalender = findViewById(R.id.mSchoolCalender)
        mSchoolCalender.setOnClickListener {
            val toSchoolCalendar = Intent(this,SchoolCalendarActivity::class.java)
            startActivity(toSchoolCalendar)
        }
//initializing School Services
        mSchoolServices = findViewById(R.id.mSchoolServices)
        mSchoolServices.setOnClickListener {
            val toSchServices = Intent(this,SchoolServicesActivity::class.java)
            startActivity(toSchServices)
        }
//initializing Fee Details
        mFeeDetails = findViewById(R.id.mFeeDetails)
        mFeeDetails.setOnClickListener {
            val toFeeDetails = Intent(this,FeeDetailsActivity::class.java)
            startActivity(toFeeDetails)
        }
//initializing Our Staff
        ourStaff = findViewById(R.id.ourStaff)
        ourStaff.setOnClickListener {
            val toStaff = Intent(this,OurStaffActivity::class.java)
            startActivity(toStaff)
        }

//initializing Contact Us

        tocontactUs = findViewById(R.id.tocontactUs)
        tocontactUs.setOnClickListener {
            val toContacts = Intent(this,ContactUsActivity::class.java)
            startActivity(toContacts)
        }


    }
}