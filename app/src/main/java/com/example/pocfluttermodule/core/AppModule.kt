package com.example.pocfluttermodule.core

import android.content.Context
import com.example.pocfluttermodule.POCFlutterModuleApplication
import com.example.pocfluttermodule.core.schedulers.SchedulersFacade
import com.example.pocfluttermodule.core.schedulers.SchedulersProvider
import com.example.pocfluttermodule.domain.authentication.repositories.AuthenRepo
import com.example.pocfluttermodule.domain.authentication.usecases.PostLoginUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext app: Context): POCFlutterModuleApplication {
        return app as POCFlutterModuleApplication
    }

    @Provides
    fun provideSchedulersProvider(): SchedulersProvider = SchedulersFacade
}