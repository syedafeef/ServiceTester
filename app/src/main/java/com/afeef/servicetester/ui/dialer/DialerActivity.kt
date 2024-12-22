package com.afeef.servicetester.ui.dialer

import android.content.ComponentName
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.telecom.PhoneAccountHandle
import android.telecom.TelecomManager
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.afeef.servicetester.R
import com.afeef.servicetester.service.MyInCallService

class DialerActivity : AppCompatActivity() {

    private lateinit var telecomManager: TelecomManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_dialer)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        telecomManager = getSystemService(Context.TELECOM_SERVICE) as TelecomManager

    }


    private fun placeCall(phoneNumber: String) {
        val uri = Uri.fromParts("tel", phoneNumber, null)
        val extras = Bundle()
        val phoneAccountHandle = PhoneAccountHandle(ComponentName(this, MyInCallService::class.java), "MyPhoneAccount")
        extras.putParcelable(TelecomManager.EXTRA_PHONE_ACCOUNT_HANDLE, phoneAccountHandle)
        telecomManager.placeCall(uri, extras)
    }
}