package com.afeef.servicetester.ui.menu

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.afeef.servicetester.R
import com.afeef.servicetester.ui.browser.LinkValidationBrowserActivity
import com.afeef.servicetester.ui.browser.YouTubePlayerActivity
import com.afeef.servicetester.ui.dialer.DialerActivity
import com.afeef.servicetester.ui.messenger.SmsActivity

class ActionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.action_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val button_call_action = findViewById<LinearLayout>(R.id.btn_call_action)
        button_call_action.setOnClickListener {
//            startActivity(Intent(this@ActionActivity, DialerActivity::class.java))
            callxyz()
        }

        val btn_web_link_validation = findViewById<LinearLayout>(R.id.btn_web_link_validation)
        btn_web_link_validation.setOnClickListener {
            startActivity(Intent(this@ActionActivity, LinkValidationBrowserActivity::class.java))
        }

        val btn_web_speed_test = findViewById<LinearLayout>(R.id.btn_web_speed_test)
        btn_web_speed_test.setOnClickListener {
            startActivity(Intent(this@ActionActivity, YouTubePlayerActivity::class.java))
        }

        val btn_sms_action = findViewById<LinearLayout>(R.id.btn_sms_action)
        btn_sms_action.setOnClickListener {
            startActivity(Intent(this@ActionActivity, SmsActivity::class.java))
        }

    }

    fun callxyz(){
        // The phone number you want to dial
        val phoneNumber = "tel:+919535090214"

        // Create an intent to open the dialer
        val dialIntent = Intent(Intent.ACTION_DIAL, Uri.parse(phoneNumber))

        // Start the activity
        startActivity(dialIntent)
    }


    /*fun registerAsCallsManager(){
        val callsManager = CallsManager(this)

        val capabilities: @CallsManager.Companion.Capability Int =
            CallsManager.CAPABILITY_BASELINE or
                    CallsManager.CAPABILITY_SUPPORTS_CALL_STREAMING or
                    CallsManager.CAPABILITY_SUPPORTS_VIDEO_CALLING

        callsManager.registerAppWithTelecom(capabilities)
    }


    private fun registerPhoneAccount() {
        val telecomManager = getSystemService(Context.TELECOM_SERVICE) as TelecomManager
        val phoneAccountHandle = PhoneAccountHandle(ComponentName(this, MyInCallService::class.java), "MyPhoneAccount")

        val phoneAccount = PhoneAccount.builder(phoneAccountHandle, "My Phone Account")
            .setCapabilities(PhoneAccount.CAPABILITY_CALL_PROVIDER)
            .build()
        telecomManager.registerPhoneAccount(phoneAccount)
    }*/
}