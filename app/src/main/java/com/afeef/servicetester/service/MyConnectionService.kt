package com.afeef.servicetester.service

import android.telecom.Connection
import android.telecom.ConnectionRequest
import android.telecom.ConnectionService
import android.telecom.PhoneAccountHandle
import com.afeef.servicetester.utils.MyConnection

class MyConnectionService : ConnectionService() {

    override fun onCreateIncomingConnection(connectionManagerPhoneAccount: PhoneAccountHandle?, request: ConnectionRequest?): Connection {
        // Handle incoming connection
        val connection = MyConnection()
        connection.setConnectionCapabilities(Connection.CAPABILITY_SUPPORT_HOLD)
        connection.setActive()
        return connection
    }

    override fun onCreateOutgoingConnection(connectionManagerPhoneAccount: PhoneAccountHandle?, request: ConnectionRequest?): Connection {
        // Handle outgoing connection
        val connection = MyConnection()
        connection.setConnectionCapabilities(Connection.CAPABILITY_SUPPORT_HOLD)
        connection.setDialing()
        return connection
    }

    override fun onCreateIncomingConnectionFailed(connectionManagerPhoneAccount: PhoneAccountHandle?, request: ConnectionRequest?) {
        // Handle incoming connection failure
    }

    override fun onCreateOutgoingConnectionFailed(connectionManagerPhoneAccount: PhoneAccountHandle?, request: ConnectionRequest?) {
        // Handle outgoing connection failure
    }
}