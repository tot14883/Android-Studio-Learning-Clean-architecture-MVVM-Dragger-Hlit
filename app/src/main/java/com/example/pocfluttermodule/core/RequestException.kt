package com.example.pocfluttermodule.core

class RequestException(val code: Int, message: String) : Throwable(message)