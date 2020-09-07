package com.example.wowzaexample.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {
    private var isLoading : MutableLiveData<Boolean> = MutableLiveData()

    fun showLoading(b : Boolean)  {
        isLoading.value = b
    }

    fun onLoading(): LiveData<Boolean> {
        return isLoading
    }

}