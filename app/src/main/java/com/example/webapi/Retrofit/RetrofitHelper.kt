package com.example.webapi.Retrofit

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import retrofit2.create

object RetrofitHelper {
    private val url=""
    private val retrofit:Retrofit=Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(SimpleXmlConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()

    fun <T> sendTable(obj:Class<T>):T {
        return retrofit.create(obj) as T
    }
}