package com.afeef.servicetester.ui.messenger

import android.telephony.SmsManager
import android.util.Log

class MessageService {

    private fun sendSMS(receiverNumber: String, messageBody: String) {
        try {
            val smsManager = SmsManager.getDefault()
            smsManager.sendTextMessage(receiverNumber, null, messageBody, null, null)
            Log.d("MessageService", "SMS Sent Successfully")
        } catch (e: Exception) {
            Log.d("MessageService",  "Failed to send SMS: ${e.message}")
        }
    }

    //todo check send ack
}