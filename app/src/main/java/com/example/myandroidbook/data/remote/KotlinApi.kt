package com.example.myandroidbook.data.remote

import com.example.myandroidbook.domain.model.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface KotlinApi {

    @GET("/learn/kotlin")
    suspend fun getAllKotlinInfo(
        @Query("page") page : Int = 1
    ) : ApiResponse

    @GET("/learn/kotlin/search")
    suspend fun searchKotlinInfo(
        @Query("title") title: String
    ) : ApiResponse

}