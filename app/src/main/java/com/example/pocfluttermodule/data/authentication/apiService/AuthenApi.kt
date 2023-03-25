package com.example.pocfluttermodule.data.authentication.apiService

import com.example.pocfluttermodule.data.authentication.models.AuthenRequest
import com.example.pocfluttermodule.data.authentication.models.AuthenResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthenApi {
    @POST("/api/v1/login")
    fun login(@Body authRequest: AuthenRequest): Single<AuthenResponse>
}