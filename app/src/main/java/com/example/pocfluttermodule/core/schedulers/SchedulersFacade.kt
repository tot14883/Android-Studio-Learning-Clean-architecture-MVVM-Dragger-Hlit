package com.example.pocfluttermodule.core.schedulers

import dagger.Provides
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Singleton

@Singleton
object SchedulersFacade: SchedulersProvider {

    override fun io(): Scheduler {
        return Schedulers.io()
    }

    override fun computation(): Scheduler {
        return Schedulers.computation()
    }

    override fun mainThread(): Scheduler {
        return AndroidSchedulers.mainThread()
    }
}