package com.example.pocfluttermodule.domain.authentication.usecases

import com.example.pocfluttermodule.core.UseCase
import com.example.pocfluttermodule.data.authentication.repositories.PostLoginRepoImpl
import com.example.pocfluttermodule.domain.authentication.models.AuthenRequestModel
import com.example.pocfluttermodule.domain.authentication.models.AuthenResponseModel
import com.example.pocfluttermodule.domain.authentication.repositories.AuthenRepo
import dagger.Provides
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject
import javax.inject.Singleton

class PostLoginUseCase @Inject constructor(val apiRepo: PostLoginRepoImpl):
 UseCase<AuthenRequestModel, AuthenResponseModel> {

    override fun execute(params: AuthenRequestModel): Single<AuthenResponseModel> {
        return apiRepo.postLogin(params);
    }
}