package com.afeef.servicetester.utils

import android.telecom.Connection
import android.telecom.DisconnectCause

class MyConnection : Connection() {

    init {
        // Set initial call state to dialing
        setDialing()
    }

    override fun onDisconnect() {
        // Handle disconnection logic
        setDisconnected(DisconnectCause(DisconnectCause.LOCAL))
        destroy()
    }

    override fun onAnswer() {
        // Handle answering the call
        setActive()
    }

    override fun onReject() {
        // Handle rejecting the call
        setDisconnected(DisconnectCause(DisconnectCause.REJECTED))
        destroy()
    }
}