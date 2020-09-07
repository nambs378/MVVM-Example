package com.example.wowzaexample.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.wowzaexample.api.APIService
import com.example.wowzaexample.api.ClientInterface
import com.example.wowzaexample.model.Data
import com.example.wowzaexample.ulti.DisposableManager
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class UserViewModel : BaseViewModel() {

    val data : MutableLiveData<Data> = MutableLiveData()

    private val _client : ClientInterface get() = APIService.getClient()

    fun getUser(page : Int) {
        _client.getUsers(page)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SingleObserver<Data?>{
                override fun onSuccess(d: Data) {
                    showLoading(false)
                    handleResponse(d)
                }

                override fun onSubscribe(d: Disposable) {
                    showLoading(true)
                    DisposableManager.add(d)
                }

                override fun onError(e: Throwable) {
                    showLoading(false)
                    handleError(e)
                }

            })
    }

    private fun handleResponse(data : Data) {
        this.data.value = data
    }

    private fun handleError(throwable: Throwable) = Log.e("ERROR", throwable.message)



}


