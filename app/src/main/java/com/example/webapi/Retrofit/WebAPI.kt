package com.example.webapi.Retrofit

import io.reactivex.Observable
import retrofit2.http.*


interface WebAPI {
        //TODO() ссылОчки и что кидать в пост-запрос

        @GET("1GetTable.php")
        fun getTable(): Observable<List<TablePOJO>>

       /* @GET("1GetTable.php")
        fun getTable(): Observable<String>*/

        @POST("папка")
        fun sendTable(@Body list:List<TablePOJO>):Observable<String>
}