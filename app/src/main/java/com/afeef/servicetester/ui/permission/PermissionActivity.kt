package com.afeef.servicetester.ui.permission

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.afeef.servicetester.ui.menu.ActionActivity
import com.afeef.servicetester.R

class PermissionActivity : AppCompatActivity() {

    private val PERMISSIONS_REQUEST_CODE = 123

    private val requiredPermissions = arrayOf(
        Manifest.permission.INTERNET,
        Manifest.permission.ANSWER_PHONE_CALLS,
        Manifest.permission.READ_CONTACTS,
        Manifest.permission.ACCESS_NETWORK_STATE,
        Manifest.permission.MANAGE_OWN_CALLS,
        Manifest.permission.READ_PHONE_STATE,
        Manifest.permission.CALL_PHONE,
        Manifest.permission.SEND_SMS,
        Manifest.permission.RECEIVE_SMS,
        Manifest.permission.READ_SMS
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        if (arePermissionsGranted()) {
            proceedToMainActivity()
        } else {
            requestPermissions()
        }
    }

    private fun arePermissionsGranted(): Boolean {
        requiredPermissions.forEach { permission ->
            if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
                return false
            }
        }
        return true
    }

    private fun requestPermissions() {
        ActivityCompat.requestPermissions(this, requiredPermissions, PERMISSIONS_REQUEST_CODE)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == PERMISSIONS_REQUEST_CODE) {
            if (grantResults.isNotEmpty() && grantResults.all { it == PackageManager.PERMISSION_GRANTED }) {
                proceedToMainActivity()
            } else {
                Toast.makeText(this, "All permissions are required to proceed", Toast.LENGTH_LONG).show()
                finish()
            }
        }
    }

    private fun proceedToMainActivity() {
        val intent = Intent(this, ActionActivity::class.java)
        startActivity(intent)
        finish()
    }
}