package com.example.wowzaexample.viewModel

import android.os.Handler

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.wowzaexample.model.UserLogin


class LoginViewModel : ViewModel() {
    val etEmail : MutableLiveData<String> = MutableLiveData()
    val etPassword : MutableLiveData<String>  = MutableLiveData()
    private var userLoginLiveData : MutableLiveData<Boolean> = MutableLiveData()

    fun loginOnClick() {
        val userLogin = UserLogin(etEmail.value,etPassword.value)

        if (userLogin.isValidCredential()) {
            Handler().postDelayed({
                userLoginLiveData.value = true


            }, 500)
        } else  userLoginLiveData.value = false

    }

    fun getUserLogin() : MutableLiveData<Boolean>{
        return userLoginLiveData
    }


}