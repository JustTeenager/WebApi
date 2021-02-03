package com.example.webapi.Retrofit

import io.reactivex.Observable
import retrofit2.http.*


interface WebAPI {
        @GET("папка")
        fun getTable(): Observable<List<TablePOJO>?>?

        @FormUrlEncoded
        @POST("папка")
        fun setTable()
}