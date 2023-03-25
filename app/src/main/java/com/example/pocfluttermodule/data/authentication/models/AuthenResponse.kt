package com.example.pocfluttermodule.data.authentication.models

import com.google.gson.annotations.SerializedName

data class AuthenResponse(
    @SerializedName("access_token") val accessToken: String,
    @SerializedName("user_id") val userId: Int,
    @SerializedName("name") val name: String,
    @SerializedName("email") val email: String
)