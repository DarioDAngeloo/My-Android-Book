package com.example.myandroidbook.di

import com.example.myandroidbook.data.local.KotlinDatabase
import com.example.myandroidbook.data.remote.KotlinApi
import com.example.myandroidbook.data.repository.RemoteDataSourceImpl
import com.example.myandroidbook.domain.repository.RemoteDataSource
import com.example.myandroidbook.util.Constants.BASE_URL
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@OptIn(ExperimentalSerializationApi::class)
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideHttpClient() : OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(15, TimeUnit.SECONDS)
            .connectTimeout(15, TimeUnit.SECONDS)
            .build()
    }


    @Provides
    @Singleton
    fun provideRetrofitInstance(okHttpClient: OkHttpClient): Retrofit{
        val contentType = "application/json".toMediaType()
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(Json.asConverterFactory(contentType))
            .build()
    }

    @Provides
    @Singleton
    fun provideKotlinApi(retrofit: Retrofit) : KotlinApi {
       return retrofit.create(KotlinApi::class.java)
    }


    @Provides
    @Singleton
    fun provideRemoteDataSource(
        kotlinApi: KotlinApi,
        kotlinDatabase: KotlinDatabase
    ) : RemoteDataSource {
        return  RemoteDataSourceImpl(
            kotlinApi = kotlinApi,
            kotlinDatabase = kotlinDatabase
        )
    }

}