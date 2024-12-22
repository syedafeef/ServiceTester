/*
package com.afeef.servicetester.service

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.telephony.TelephonyManager
import androidx.core.app.ActivityCompat


class PhoneCallService {

    fun makeCall(context: Context, phoneNumber: String, duration: Long) {
        val callIntent = Intent(Intent.ACTION_CALL).apply {
            data = Uri.parse("tel:$phoneNumber")
        }

        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
            context.startActivity(callIntent)
            // Disconnect the call after the specified duration
            Handler(Looper.getMainLooper()).postDelayed({
                endCall(context)
            }, duration * 60 * 1000) // Convert duration to milliseconds
        } else {
            // Request Permission
            ActivityCompat.requestPermissions(
                (context as Activity),
                arrayOf(Manifest.permission.CALL_PHONE),
                101
            )
        }
    }

    fun endCall(context: Context) {
        try {
            val telephonyManager = context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                // Android P and above: Use endCall() directly
//                telephonyManager.endCall()
//                endCallSystemFunctionCheck(context)
            } else {
                // Below Android P: Use reflection to access ITelephony
                */
/*val clazz = Class.forName(telephonyManager.javaClass.name)
                val method = clazz.getDeclaredMethod("getITelephony")
                method.isAccessible = true
                val iTelephony = method.invoke(telephonyManager)
                val endCallMethod = iTelephony.javaClass.getDeclaredMethod("endCall")
                endCallMethod.isAccessible = true
                endCallMethod.invoke(iTelephony)*//*

            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }



    fun endCallSystemFunctionCheck(context: Context) {
        */
/*try {
            // Get TelephonyManager instance
            val telephonyManager = context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager

            // Access hidden method `getITelephony`
            val telephonyClass = Class.forName(telephonyManager.javaClass.name)
            val getITelephonyMethod = telephonyClass.getDeclaredMethod("getITelephony")
            getITelephonyMethod.isAccessible = true

            val iTelephony = getITelephonyMethod.invoke(telephonyManager)

            // Access `endCall` method in ITelephony
            val endCallMethod = iTelephony.javaClass.getDeclaredMethod("endCall")
            endCallMethod.isAccessible = true

            // Invoke `endCall` to disconnect the call
            endCallMethod.invoke(iTelephony)
        } catch (e: Exception) {
            e.printStackTrace()
        }*//*

    }


}*/
