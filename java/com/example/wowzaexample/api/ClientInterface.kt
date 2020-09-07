package com.example.wowzaexample.api

import com.example.wowzaexample.model.Data
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ClientInterface {

    @GET("api/users")
    fun getUsers(@Query("page") page: Int): Single<Data?>



}