package com.example.pocfluttermodule.domain.authentication.models

data class AuthenResponseModel(
    val accessToken: String,
    val user_id: Int,
    val name: String,
    val email: String
)
