package com.afeef.servicetester.utils

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresExtension
import okhttp3.Interceptor
import okhttp3.Protocol
import okhttp3.Response
import okhttp3.ResponseBody
import okhttp3.internal.http2.ConnectionShutdownException
import okio.IOException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

class NetworkInterceptor : Interceptor {
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val url = request.url
        Log.d("Request URL::", url.toString())
        try {
            val response = chain.proceed(request)
            val bodyString = response.body?.string()
            bodyString?.let {
                Log.d("Response Body",it)
            }

            return response.newBuilder()
                .body(bodyString?.let { ResponseBody.create(response.body?.contentType(), it) })
                .build()

        } catch (e: Exception) {
            e.printStackTrace()
            var msg = ""
            when (e) {
                is SocketTimeoutException -> {
                    msg = "Timeout - Please check your internet connection"
                }
                is UnknownHostException -> {
                    msg = "Unable to make a connection. Please check your internet"
                }
                is ConnectionShutdownException -> {
                    msg = "Connection shutdown. Please check your internet"
                }
                is IOException -> {
                    msg = "Server is unreachable, please try again later."
                }
                is IllegalStateException -> {
                    msg = "${e.message}"
                }
                else -> {
                    msg = "${e.message}"
                }
            }

            return Response.Builder()
                .request(request)
                .protocol(Protocol.HTTP_1_1)
                .code(999)
                .message(msg)
                .body(ResponseBody.create(null, msg)).build()
        }
    }


}