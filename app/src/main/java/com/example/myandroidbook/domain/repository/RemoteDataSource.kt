package com.example.myandroidbook.domain.repository

import androidx.paging.PagingData
import com.example.myandroidbook.domain.model.KotlinModel
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {
    fun getAllData() : Flow<PagingData<KotlinModel>>
    fun searchKotlinInfo(): Flow<PagingData<KotlinModel>>
}