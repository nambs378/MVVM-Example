package com.example.wowzaexample.adapter

import android.view.DragAndDropPermissions
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.wowzaexample.R
import com.example.wowzaexample.model.User
import com.example.wowzaexample.model.UserLogin
import kotlinx.android.synthetic.main.item_user.view.*

class UserAdapter : BaseRecyclerAdapter<User>() {
    override fun layoutResource(model: User, position: Int): Int  = R.layout.item_user

    override fun View.onBindModel(model: User, position: Int, layout: Int) {

        Glide.with(iv_avatar).load(model.avatar).transition(DrawableTransitionOptions.withCrossFade()).centerCrop().into(iv_avatar)

        tv_name.text = model.firstName

    }

}