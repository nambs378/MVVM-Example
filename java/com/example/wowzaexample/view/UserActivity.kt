package com.example.wowzaexample.view

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.wowzaexample.R
import com.example.wowzaexample.adapter.UserAdapter
import com.example.wowzaexample.ulti.DisposableManager
import com.example.wowzaexample.viewModel.UserViewModel
import kotlinx.android.synthetic.main.nam_user.*

class UserActivity : AppCompatActivity() {

    val userAdapter : UserAdapter = UserAdapter()

//    var userViewModel : UserViewModel? = null //nen dung lazy init

    private val userViewModel : UserViewModel by lazy{
        ViewModelProviders.of(this).get(UserViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.nam_user)

        addControl()


//      userAdapter.set()

        initData()
        getData()

    }

    private fun getData() {
        userViewModel.getUser(1)

    }

    private fun initData() {
        userViewModel.data.observe(this, Observer {
            Log.e("testUser", it.user.toString())
            userAdapter.set(it.user)
        })

        userViewModel.onLoading().observe(this, Observer {
            var progressBarView = if (it) View.VISIBLE else View.INVISIBLE
            progressBar.visibility = progressBarView
        })

    }

    private fun addControl() {
        userAdapter.bind(id_recyclerview)
    }

    override fun onDestroy() {
        super.onDestroy()
        DisposableManager.dispose()
    }

}
