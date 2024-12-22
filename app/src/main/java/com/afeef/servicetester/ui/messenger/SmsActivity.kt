package com.afeef.servicetester.ui.messenger

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.telephony.SmsManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.afeef.servicetester.R

class SmsActivity : AppCompatActivity() {

    private lateinit var ackStatusTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sms)

        val phoneNumberEditText = findViewById<EditText>(R.id.phone_number)
        val messageBodyEditText = findViewById<EditText>(R.id.message_body)
        val sendButton = findViewById<Button>(R.id.send_button)
        ackStatusTextView = findViewById<TextView>(R.id.ack_status)

        sendButton.setOnClickListener {
            sendSms(phoneNumberEditText.text.toString(), messageBodyEditText.text.toString())
        }

        // Request SMS permission if not granted
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.SEND_SMS), 1)
        }
    }

    private fun sendSms(phoneNumber :String, messageBody :String) {

        if (phoneNumber.isNotEmpty() && messageBody.isNotEmpty()) {
            try {
                val smsManager = SmsManager.getDefault()
                smsManager.sendTextMessage(phoneNumber, null, messageBody, null, null)
                ackStatusTextView.text = "Status: Message sent successfully"
            } catch (e: Exception) {
                ackStatusTextView.text = "Status: Failed to send message"
                e.printStackTrace()
            }
        } else {
            ackStatusTextView.text = "Status: Please enter both phone number and message"
        }
    }
}
