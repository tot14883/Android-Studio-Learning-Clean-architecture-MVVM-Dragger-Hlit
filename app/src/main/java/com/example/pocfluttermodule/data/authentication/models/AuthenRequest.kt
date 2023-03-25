package com.example.pocfluttermodule.data.authentication.models

import com.google.gson.annotations.SerializedName

data class AuthenRequest(
    @SerializedName("email") val email: String,
    @SerializedName("password") val password: String
)
