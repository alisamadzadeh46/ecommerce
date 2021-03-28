package com.example.ecommerce.utils

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ecommerce.R
import io.reactivex.rxjava3.core.SingleObserver
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable

abstract class BaseViewModel : ViewModel() {
    val compositeDisposable = CompositeDisposable()
    val progressbarLiveData = MutableLiveData<Boolean>()
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

interface ViewProgress {
    val root: ConstraintLayout?
    val myContext: Context?
    fun progress(show: Boolean) {
        root?.let { view ->
            myContext?.let { context ->
                var progressbar = view.findViewById<View>(R.id.progress_bar)
                if (progressbar == null && show) {
                    progressbar =
                        LayoutInflater.from(context).inflate(R.layout.progressbar, view, false)
                    view.addView(progressbar)
                }
                progressbar?.visibility = if (show) View.VISIBLE else View.GONE
            }
        }
    }
}

abstract class Activity : AppCompatActivity(), ViewProgress {

}

abstract class Fragment : Fragment(), ViewProgress {
    override val root: ConstraintLayout?
        get() = view as ConstraintLayout
    override val myContext: Context?
        get() = context
}