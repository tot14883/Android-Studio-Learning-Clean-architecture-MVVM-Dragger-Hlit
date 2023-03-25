package com.example.pocfluttermodule.data.authentication.mappers

import com.example.pocfluttermodule.data.authentication.models.AuthenResponse
import com.example.pocfluttermodule.domain.authentication.models.AuthenResponseModel
import javax.inject.Inject

class AuthenMapper @Inject constructor() {
    fun toAuthenDetail(authReponse: AuthenResponse): AuthenResponseModel {
        return AuthenResponseModel(
            authReponse.accessToken,
            authReponse.userId,
            authReponse.name,
            authReponse.email,
        )
    }
}