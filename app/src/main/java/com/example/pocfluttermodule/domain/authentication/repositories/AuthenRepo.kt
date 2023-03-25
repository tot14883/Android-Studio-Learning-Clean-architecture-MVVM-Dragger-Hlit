package com.example.pocfluttermodule.domain.authentication.repositories

import com.example.pocfluttermodule.domain.authentication.models.AuthenRequestModel
import com.example.pocfluttermodule.domain.authentication.models.AuthenResponseModel
import dagger.Module
import dagger.Provides
import io.reactivex.rxjava3.core.Single

interface AuthenRepo {
    fun postLogin(authRequest: AuthenRequestModel): Single<AuthenResponseModel>
}