package com.example.wowzaexample.ulti

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

object DisposableManager  {
    private var compositeDisposable: CompositeDisposable? = null

    private fun DisposableManager() {}

    fun add(disposable: Disposable?) {
        getCompositeDisposable().add(disposable!!)
    }

    fun dispose() {
        getCompositeDisposable().dispose()
    }

    private fun getCompositeDisposable(): CompositeDisposable {
        if (compositeDisposable == null || compositeDisposable!!.isDisposed) {
            compositeDisposable = CompositeDisposable()
        }
        return compositeDisposable!!
    }
}