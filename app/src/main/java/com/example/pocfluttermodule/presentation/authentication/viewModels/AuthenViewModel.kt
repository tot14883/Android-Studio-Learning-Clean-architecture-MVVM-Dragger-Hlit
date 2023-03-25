package com.example.pocfluttermodule.presentation.authentication.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pocfluttermodule.common.components.BaseViewModel
import com.example.pocfluttermodule.core.schedulers.SchedulersProvider
import com.example.pocfluttermodule.domain.authentication.models.AuthenRequestModel
import com.example.pocfluttermodule.domain.authentication.models.AuthenResponseModel
import com.example.pocfluttermodule.domain.authentication.usecases.PostLoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable
import javax.inject.Inject

@HiltViewModel
class AuthenViewModel @Inject constructor(
    val postUseCase: PostLoginUseCase,
    val schedulers: SchedulersProvider,
): ViewModel() {
    private val _userInfo = MutableLiveData<AuthenResponseModel>()
    val userInfo: LiveData<AuthenResponseModel> = _userInfo
    protected val compositeDisposable = CompositeDisposable()

    fun test() {
        Log.d("TEST", "Passed")
    }

    fun postLogin(login: AuthenRequestModel) {
        postUseCase.execute(login).subscribeOn(schedulers.io()).subscribe({
            it.let {
                _userInfo.postValue(it)
            }
        }, {

        }).let {
            compositeDisposable.add(it)
        }
    }

    override fun onCleared() {
        compositeDisposable.clear()
    }
}