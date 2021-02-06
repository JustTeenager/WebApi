package com.example.webapi.Retrofit

import io.reactivex.Observable
import retrofit2.http.*


interface WebAPI {
        @GET("dev_vasilevskiy_01/ws/ws1.1cws?wsdl")
        fun getTable(): Observable<List<TablePOJO>?>?

        @FormUrlEncoded
        @POST("папка")
        fun setTable()
}