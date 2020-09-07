package com.example.wowzaexample.model

import android.text.TextUtils
import android.util.Patterns

data class UserLogin(var email: String?, var password: String?) {

    fun isValidCredential(): Boolean {
        return this.email.equals(
                "nam",
                ignoreCase = true
            ) && this.password == "1234"
    }

}