package com.afeef.servicetester.data.repository

import com.afeef.servicetester.data.remote.UrlCheckerService
import retrofit2.Call
import javax.inject.Inject

class UrlRepository @Inject constructor(private val urlCheckerService: UrlCheckerService) {

    fun checkUrl(url: String, callback: (Boolean) -> Unit) {
        val call = urlCheckerService.checkUrl(url)
        call.enqueue(object : retrofit2.Callback<Void> {
            override fun onResponse(call: Call<Void>, response: retrofit2.Response<Void>) {
                callback(response.isSuccessful)
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                callback(false)
            }
        })
    }

}