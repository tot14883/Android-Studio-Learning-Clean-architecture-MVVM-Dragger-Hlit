package com.example.pocfluttermodule.domain.authentication.models

import com.google.gson.annotations.SerializedName

data class AuthenRequestModel (
    val email: String,
    val password: String
)
