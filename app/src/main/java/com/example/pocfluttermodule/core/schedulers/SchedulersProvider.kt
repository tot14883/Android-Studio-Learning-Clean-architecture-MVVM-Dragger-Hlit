package com.example.pocfluttermodule.core.schedulers

import io.reactivex.rxjava3.core.Scheduler

interface SchedulersProvider {
    fun mainThread(): Scheduler
    fun io(): Scheduler
    fun computation(): Scheduler
}