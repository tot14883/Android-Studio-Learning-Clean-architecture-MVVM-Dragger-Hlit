package com.example.pocfluttermodule.data.authentication.repositories

import android.util.Log
import com.example.pocfluttermodule.data.authentication.apiService.AuthenApi
import com.example.pocfluttermodule.data.authentication.mappers.AuthenMapper
import com.example.pocfluttermodule.data.authentication.models.AuthenRequest
import com.example.pocfluttermodule.domain.authentication.models.AuthenRequestModel
import com.example.pocfluttermodule.domain.authentication.models.AuthenResponseModel
import com.example.pocfluttermodule.domain.authentication.repositories.AuthenRepo
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class PostLoginRepoImpl @Inject constructor(
    private val apiService: AuthenApi,
    private val mapper: dagger.Lazy<AuthenMapper>
): AuthenRepo {
    override fun postLogin(authRequest: AuthenRequestModel): Single<AuthenResponseModel> {
        val request =  AuthenRequest(
            authRequest.email,
            authRequest.password,
        )

        return apiService.login(request)
            .map {
                Log.d("LOGIN_RESPONSE", it.toString())
                mapper.get().toAuthenDetail(it)
            }
    }

}