package com.example.pocfluttermodule.core.networkModule

import android.content.SharedPreferences
import com.example.pocfluttermodule.common.Constants.TOKEN_KEY
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class NetworkInterceptor @Inject constructor(private val prefs: SharedPreferences): Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()

        val request = original.newBuilder()
        request.addHeader("Accept", "application/json")
        prefs.getString(TOKEN_KEY, null)?.let { token ->
            request.addHeader("Authorization", "Bearer $token")
        }

        return chain.proceed(request.build())
    }
}