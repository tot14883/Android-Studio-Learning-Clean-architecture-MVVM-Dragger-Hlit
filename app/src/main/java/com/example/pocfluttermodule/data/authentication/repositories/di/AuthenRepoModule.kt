package com.example.pocfluttermodule.data.authentication.repositories.di


import com.example.pocfluttermodule.data.authentication.apiService.AuthenApi
import com.example.pocfluttermodule.data.authentication.mappers.AuthenMapper
import com.example.pocfluttermodule.data.authentication.repositories.PostLoginRepoImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AuthenRepoModule {

    @Singleton
    @Provides
    fun providePostRepoProvider(
        apiService: AuthenApi,
        mapper: dagger.Lazy<AuthenMapper>
    ) = PostLoginRepoImpl(apiService, mapper)
}