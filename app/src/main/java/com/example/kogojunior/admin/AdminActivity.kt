package com.example.kogojunior.admin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import com.example.kogojunior.*

class AdminActivity : AppCompatActivity() {

    private lateinit var tocontactUs: CardView
    private lateinit var ourStaff: CardView
    private lateinit var mGeneralInfo: CardView
    private lateinit var mSchoolCalender: CardView
    private lateinit var mSchoolServices: CardView
    private lateinit var mFeeDetails: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)

        //initializing General Info

        mGeneralInfo = findViewById(R.id.mGeneralInfo)
        mGeneralInfo.setOnClickListener {
            val toGenInfo = Intent(this,EditStaffActivity::class.java)
            startActivity(toGenInfo)
        }
        //initializing School Calender
        mSchoolCalender = findViewById(R.id.mSchoolCalender)
        mSchoolCalender.setOnClickListener {
            val toSchoolCalendar = Intent(this, CalenderEventsActivity::class.java)
            startActivity(toSchoolCalendar)
        }
//initializing School Services
        mSchoolServices = findViewById(R.id.mSchoolServices)
        mSchoolServices.setOnClickListener {
            val toSchServices = Intent(this, EditSchoolServicesActivity::class.java)
            startActivity(toSchServices)
        }
//initializing Fee Details
        mFeeDetails = findViewById(R.id.mFeeDetails)
        mFeeDetails.setOnClickListener {
            val toFeeDetails = Intent(this, FeeSummaryActivity::class.java)
            startActivity(toFeeDetails)
        }
//initializing Our Staff


//initializing Contact Us

        tocontactUs = findViewById(R.id.tocontactUs)
        tocontactUs.setOnClickListener {
            val toContacts = Intent(this, ContactStaffActivity::class.java)
            startActivity(toContacts)
        }
    }
}