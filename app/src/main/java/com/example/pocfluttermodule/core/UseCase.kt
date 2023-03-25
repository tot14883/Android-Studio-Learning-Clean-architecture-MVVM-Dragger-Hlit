package com.example.pocfluttermodule.core

import io.reactivex.rxjava3.core.Single

interface UseCase<P, R : Any> {
    fun execute(params: P): Single<R>
}