package com.example.kogojunior

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class ContactUsActivity : AppCompatActivity() {

    var call: TextView? = null
    var feedback : TextView? = null
    var send_your_message: TextView? = null
    var facebook: ImageView? = null
    var instagram: ImageView? = null
    var youtube: ImageView? = null
    var share: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_us)

        call = findViewById(R.id.call)
        call!!.setOnClickListener{
            val callIntent = Intent(Intent.ACTION_CALL)
            callIntent.data = Uri.parse("tel:+254795124927")
            startActivity(callIntent)
        }
        feedback = findViewById(R.id.feedback)
        feedback!!.setOnClickListener{
            val intent = Intent(Intent.ACTION_SENDTO)
            val uriText =
                "mailto:" + Uri.encode("kogojunior@gmail.com").toString() + "?subject=" +
                        Uri.encode("your email id ").toString() + "&body=" + Uri.encode("")
            val uri: Uri = Uri.parse(uriText)
            intent.setData(uri)
            startActivity(Intent.createChooser(intent, "Send Email"))
        }
//        send message via text/whatsapp
        send_your_message = findViewById(R.id.send_your_message)
        send_your_message!!.setOnClickListener{
//            send sms



        }
        facebook = findViewById(R.id.facebook)
        facebook!!.setOnClickListener {

            gotoUrl("https://www.facebook.com/kogojunior")
        }
        youtube = findViewById(R.id.youtube)
        youtube!!.setOnClickListener {

            gotoYoutube("https://www.youtube.com")
        }
        instagram = findViewById(R.id.instagram)
        instagram!!.setOnClickListener{
            gotoIg("https://www.instagram.com")
        }

        share = findViewById(R.id.share)
        share!!.setOnClickListener{
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.type = "text/plain"
            val sharebody = "look all Programmings"
            val subject =
                "https://play.google.com/store/apps/"
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, sharebody)
            shareIntent.putExtra(Intent.EXTRA_TEXT, subject)
            startActivity(Intent.createChooser(shareIntent, "Seek my vision"))
        }
    }

    private fun gotoUrl(s: String) {
        val uri: Uri = Uri.parse(s)
        startActivity(Intent(Intent.ACTION_VIEW, uri))
    }
    private fun gotoYoutube(s: String) {
        val uri: Uri = Uri.parse(s)
        startActivity(Intent(Intent.ACTION_VIEW, uri))
    }
    private fun gotoIg(s: String) {
        val uri: Uri = Uri.parse(s)
        startActivity(Intent(Intent.ACTION_VIEW, uri))
    }
}
