package com.example.kogojunior.admin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import com.example.kogojunior.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class EditStaffActivity : AppCompatActivity() {

    var listUsers: ListView?= null
    var adapter:StaffCustomAdapter ?= null
    var users:ArrayList<Staff> ?= null
    val addBtn: FloatingActionButton?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_staff)

        listUsers = findViewById(R.id.userRecyclerView)
        users = ArrayList()
        adapter = StaffCustomAdapter( this,users!!)

        val reference = FirebaseDatabase.getInstance().getReference()
            .child("Staff")
//        start fetch the data
        reference.addValueEventListener(object : ValueEventListener {
            //Override the on data changed method
            override fun onDataChange(snapshot: DataSnapshot) {
                users!!.clear()
//                use for each loop to add the users to the arrays
                for (snap in snapshot.children){
                    var staff = snap.getValue(Staff::class.java)
                    users!!.add(staff!!)
                }
                adapter!!.notifyDataSetChanged()
            }
            //override the onCancelled method
            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(applicationContext,"Please contact the Admin", Toast.LENGTH_LONG).show()
            }
        })
        listUsers!!.adapter = adapter!!




////        set on on item click listener on the list view
//        listUsers!!.setOnItemClickListener { adapterView, view, i, l ->
//            var userId = users!!.get(i).id
//            val deletionReference = FirebaseDatabase.getInstance().getReference().child("Users/$userId")
////            set an alert when someone clicks on an item
//            var alertDialog = AlertDialog.Builder(this)
//            alertDialog.setTitle("ALERT!!")
//            alertDialog.setMessage("select an option you want to perform")
//            alertDialog.setNegativeButton("Update", DialogInterface.OnClickListener { dialogInterface, i ->
//                //dismiss the alert
//            })
//            alertDialog.setPositiveButton("delete", DialogInterface.OnClickListener { dialogInterface, i ->
//                reference.removeValue()
//                Toast.makeText(applicationContext,"Deleted successfully", Toast.LENGTH_LONG).show()
//            })
//        }
    }
}
