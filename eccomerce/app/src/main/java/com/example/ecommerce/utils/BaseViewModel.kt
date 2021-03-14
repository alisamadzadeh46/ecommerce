package com.example.ecommerce.utils

import android.util.Log
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.core.SingleObserver
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable

abstract class BaseViewModel : ViewModel() {
    val compositeDisposable = CompositeDisposable()

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}

abstract class Observer<T>(private val compositeDisposable: CompositeDisposable) :
    SingleObserver<T> {
    override fun onSubscribe(d: Disposable?) {
        compositeDisposable.add(d)
    }

    override fun onError(e: Throwable?) {
        Log.i("LOG", e.toString())
    }

}