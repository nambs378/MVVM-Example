package com.example.wowzaexample.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.wowzaexample.R
import com.example.wowzaexample.viewModel.LoginViewModel

import com.example.wowzaexample.databinding.ActivityMainBinding
import com.example.wowzaexample.model.UserLogin

class MainActivity : AppCompatActivity() {
    private val loginViewModel: LoginViewModel by lazy {
        ViewModelProviders.of(this).get(LoginViewModel::class.java)
    }

    private var userLogin : UserLogin? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this,
                R.layout.activity_main
            )



        binding.lifecycleOwner = this
        binding.loginViewModel = loginViewModel

        userLogin = UserLogin("hah","hehe")

//        binding.textString = userLogin!!.email


        loginViewModel.getUserLogin().observe(this, Observer {
            if (it) {
                Toast.makeText(this,"Logging Success", Toast.LENGTH_SHORT).show()
                var intent: Intent = Intent(this,UserActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this,"Logging fail, try again", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
