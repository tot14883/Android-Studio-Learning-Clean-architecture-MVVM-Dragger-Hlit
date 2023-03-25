package com.example.pocfluttermodule.data.authentication.apiService.di

import com.example.pocfluttermodule.core.networkModule.NetworkModule
import com.example.pocfluttermodule.data.authentication.apiService.AuthenApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module(includes = [NetworkModule::class])
@InstallIn(SingletonComponent::class)
class AuthApiModule {
    @Provides
    fun bindAuthenApi(retrofit: Retrofit): AuthenApi {
        return retrofit.create(AuthenApi::class.java)
    }
}