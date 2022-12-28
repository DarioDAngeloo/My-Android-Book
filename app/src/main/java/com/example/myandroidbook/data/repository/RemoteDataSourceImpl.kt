package com.example.myandroidbook.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.myandroidbook.data.local.KotlinDatabase
import com.example.myandroidbook.data.paging_source.KotlinInfoRemoteMediator
import com.example.myandroidbook.data.remote.KotlinApi
import com.example.myandroidbook.domain.model.KotlinModel
import com.example.myandroidbook.domain.repository.RemoteDataSource
import com.example.myandroidbook.util.Constants.ITEMS_PER_PAGE
import kotlinx.coroutines.flow.Flow

@OptIn(ExperimentalPagingApi::class)
class RemoteDataSourceImpl(
    private val kotlinApi: KotlinApi,
    private val kotlinDatabase: KotlinDatabase
): RemoteDataSource  {

    private val kotlinDao = kotlinDatabase.kotlinDao()

    override fun getAllData(): Flow<PagingData<KotlinModel>> {
        val pagingSourceFactory =  { kotlinDao.getAllKotlinInfo() }
        return Pager(
            config = PagingConfig(pageSize = ITEMS_PER_PAGE),
            remoteMediator = KotlinInfoRemoteMediator(
                kotlinApi = kotlinApi,
                kotlinDatabase = kotlinDatabase
            ),
            pagingSourceFactory = pagingSourceFactory
        ).flow
    }

    override fun searchKotlinInfo(): Flow<PagingData<KotlinModel>> {
        TODO("Not yet implemented")
    }
}