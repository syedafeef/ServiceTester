package com.afeef.servicetester.ui.browser

import android.app.AlertDialog
import android.net.TrafficStats
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.afeef.servicetester.R


class YouTubePlayerActivity : AppCompatActivity() {

    private lateinit var webView: WebView
    private lateinit var data_used: TextView
    private var initialRxBytes: Long = 0
    private var handler: Handler? = null
    private var dataUsageChecker: Runnable? = null
    private var startTime: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_youtube)

        webView = findViewById(R.id.webView)
        data_used = findViewById(R.id.tv_data_used)

        webView.setWebViewClient(WebViewClient())
        webView.getSettings().javaScriptEnabled = true
        webView.loadUrl("https://www.youtube.com")

        initialRxBytes = TrafficStats.getUidRxBytes(applicationInfo.uid)
        handler = Handler(Looper.getMainLooper())
        startTime = System.currentTimeMillis();

        dataUsageChecker = object : Runnable {
            override fun run() {
                val currentRxBytes = TrafficStats.getUidRxBytes(applicationInfo.uid)
                val dataUsed = currentRxBytes - initialRxBytes

                val dataUsedInMB = dataUsed/(1024 * 1024)

                data_used.text = "Data usage : $dataUsedInMB MB"

                if (dataUsed > MAX_DATA_USAGE) {
                    webView.stopLoading()
                    webView.loadUrl("about:blank")
                    showStatsDialog(dataUsed)
                    Toast.makeText(this@YouTubePlayerActivity, "Data usage limit reached. Stopping playback.", Toast.LENGTH_LONG).show()
                } else {
                    handler!!.postDelayed(this, 1000)
                }
            }
        }
        handler!!.post(dataUsageChecker as Runnable)
    }

    override fun onDestroy() {
        super.onDestroy()
        handler!!.removeCallbacks(dataUsageChecker!!)
    }

    private fun showStatsDialog(dataUsed: Long) {
        val endTime = System.currentTimeMillis()
        val duration = (endTime - startTime) / 1000 // in seconds
        val speed = (dataUsed / 1024.0) / duration // KB/s

        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        val inflater = layoutInflater
        val dialogView: View = inflater.inflate(R.layout.dialog_stats, null)

        builder.setView(dialogView)
            .setTitle("Network Usage Statistics")
            .setPositiveButton("Ok") { dialog, which ->
                // Close the activity when "Yes" is clicked
                finish()
            }

        val tvDataUsed = dialogView.findViewById<TextView>(R.id.tvDataUsed)
        val tvSpeed = dialogView.findViewById<TextView>(R.id.tvSpeed)
        val tvTimeTaken = dialogView.findViewById<TextView>(R.id.tvTimeTaken)

        tvDataUsed.text = String.format("Data Used: %.2f MB", dataUsed / (1024.0 * 1024.0))
        tvSpeed.text = String.format("Speed: %.2f KB/s", speed)
        //todo show network graph
        tvTimeTaken.text = "Time Taken: $duration Seconds"

        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    companion object {
        private const val MAX_DATA_USAGE = (20 * 1024 * 1024).toLong() // 20MB
    }
}