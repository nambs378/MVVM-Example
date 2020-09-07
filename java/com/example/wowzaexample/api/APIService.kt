package com.example.wowzaexample.api

import com.example.wowzaexample.ulti.Constant
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object APIService {
    private var retrofit : Retrofit? = null

    fun getClient(): ClientInterface {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        val builder = OkHttpClient.Builder()
        builder.readTimeout(30, TimeUnit.SECONDS)
        builder.connectTimeout(30, TimeUnit.SECONDS)
        builder.writeTimeout(30, TimeUnit.SECONDS)
        builder.addInterceptor(loggingInterceptor)

        if (retrofit == null) {
            retrofit =
                Retrofit.Builder().baseUrl(Constant.BASE_URL).client(builder.build())
                    .addCallAdapterFactory(
                        RxJava2CallAdapterFactory.create()
                    ).addConverterFactory(GsonConverterFactory.create()).build()
        }

        return retrofit!!.create(ClientInterface::class.java)
    }





}