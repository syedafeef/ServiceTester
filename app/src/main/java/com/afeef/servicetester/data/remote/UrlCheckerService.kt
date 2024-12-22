package com.afeef.servicetester.data.remote

import retrofit2.http.HEAD
import retrofit2.http.Url
import retrofit2.Call

interface UrlCheckerService {
    @HEAD
    fun checkUrl(@Url url: String): Call<Void>
}