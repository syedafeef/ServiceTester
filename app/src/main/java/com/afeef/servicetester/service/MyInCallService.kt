package com.afeef.servicetester.service

import android.os.Handler
import android.os.Looper
import android.telecom.Call
import android.telecom.InCallService

class MyInCallService : InCallService() {

    private val handler = Handler(Looper.getMainLooper())
    private var disconnectRunnable: Runnable? = null

    override fun onCallAdded(call: Call) {
        super.onCallAdded(call)
        // Handle new call
        call.registerCallback(callCallback)
    }

    override fun onCallRemoved(call: Call) {
        super.onCallRemoved(call)
        // Handle call removal
        call.unregisterCallback(callCallback)
    }

    private val callCallback = object : Call.Callback() {
        override fun onStateChanged(call: Call, state: Int) {
            super.onStateChanged(call, state)
            when (state) {
                Call.STATE_ACTIVE -> {
                    // Call is active, schedule disconnection after 5 minutes
                    disconnectRunnable = Runnable {
                        call.disconnect()
                    }
                    handler.postDelayed(disconnectRunnable!!, 1 * 60 * 1000) // 5 minutes in milliseconds
                }
                Call.STATE_DISCONNECTED -> {
                    // Call was disconnected, cancel the scheduled disconnection
                    handler.removeCallbacks(disconnectRunnable!!)
                }
            }
        }
    }
}