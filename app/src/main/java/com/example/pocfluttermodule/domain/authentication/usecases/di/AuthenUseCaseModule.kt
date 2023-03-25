package com.example.pocfluttermodule.core

import com.example.pocfluttermodule.data.authentication.apiService.AuthenApi
import com.example.pocfluttermodule.data.authentication.mappers.AuthenMapper
import com.example.pocfluttermodule.data.authentication.repositories.PostLoginRepoImpl
import com.example.pocfluttermodule.domain.authentication.repositories.AuthenRepo
import com.example.pocfluttermodule.domain.authentication.usecases.PostLoginUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AuthenUseCaseModule {

    @Singleton
    @Provides
    fun providePostUseCaseProvider(
        apiRepo: PostLoginRepoImpl
    ) = PostLoginUseCase(apiRepo)
}