package com.example.myandroidbook.data.paging_source

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.example.myandroidbook.data.local.KotlinDatabase
import com.example.myandroidbook.data.local.dao.KotlinRemoteKeysDao
import com.example.myandroidbook.data.remote.KotlinApi
import com.example.myandroidbook.domain.model.KotlinModel
import com.example.myandroidbook.domain.model.KotlinRemoteKeys
import javax.inject.Inject
import java.lang.Exception

@ExperimentalPagingApi
class KotlinInfoRemoteMediator @Inject constructor(
    private val kotlinApi: KotlinApi, private val kotlinDatabase: KotlinDatabase
) : RemoteMediator<Int, KotlinModel>() {


    private val kotlinDao = kotlinDatabase.kotlinDao()
    private val kotlinInfoRemoteKeysDao = kotlinDatabase.kotlinRemoteKeysDao()

    override suspend fun load(
        loadType: LoadType, state: PagingState<Int, KotlinModel>
    ): MediatorResult {
        return try {

            val page = when (loadType) {
                LoadType.REFRESH -> {
                    val remoteKeys = getRemoteKeysClosestToCurrentPosition(state)
                    remoteKeys?.nextPage?.minus(1) ?: 1
                }
                LoadType.PREPEND -> {
                    val remoteKeys = getRemoteKeyForFirstItem(state)
                    val prevPage = remoteKeys?.prevPage ?: return MediatorResult.Success(
                        endOfPaginationReached = remoteKeys != null
                    )
                    prevPage
                }
                LoadType.APPEND -> {
                    val remoteKeys = getRemoteKeyForLastItem(state)
                    val nextPAge = remoteKeys?.nextPage ?: return MediatorResult.Success(
                        endOfPaginationReached = remoteKeys != null
                    )
                    nextPAge
                }

            }

            val response = kotlinApi.getAllKotlinInfo(page = page)
            if (response.infoKotlin.isNotEmpty()) {
                kotlinDatabase.withTransaction {
                    if (loadType == LoadType.REFRESH) {
                        kotlinDao.deleteAllKotlinInfo()
                        kotlinInfoRemoteKeysDao.deleteAllRemoteKeys()
                    }
                    val prevPage = response.prevPage
                    val nextPage = response.nextPage
                    val keys = response.infoKotlin.map { kotlinInfo ->
                        KotlinRemoteKeys(
                            id = kotlinInfo.id, prevPage = prevPage, nextPage = nextPage
                        )
                    }
                    kotlinInfoRemoteKeysDao.addAllRemoteKeys(kotlinRemoteKeys = keys)
                    kotlinDao.addKotlinInfo(koltlinList = response.infoKotlin)
                }
            }
            MediatorResult.Success(endOfPaginationReached = response.nextPage == null)

        } catch (e: Exception) {
            return MediatorResult.Error(e)
        }
    }


    private suspend fun getRemoteKeysClosestToCurrentPosition(
        state: PagingState<Int, KotlinModel>
    ): KotlinRemoteKeys? {
        return state.anchorPosition?.let { position ->
            state.closestItemToPosition(position)?.id?.let { id ->
                kotlinInfoRemoteKeysDao.getRemoteKey(id = id)
            }
        }
    }

    private suspend fun getRemoteKeyForFirstItem(
        state: PagingState<Int, KotlinModel>
    ): KotlinRemoteKeys? {
        return state.pages.firstOrNull() { it.data.isNotEmpty() }?.data?.firstOrNull()
            ?.let { kotlinInfo ->
                kotlinInfoRemoteKeysDao.getRemoteKey(id = kotlinInfo.id)
            }
    }


    private suspend fun getRemoteKeyForLastItem(
        state: PagingState<Int, KotlinModel>
    ): KotlinRemoteKeys? {
        return state.pages.lastOrNull() { it.data.isNotEmpty() }?.data?.lastOrNull()
            ?.let { kotlinInfo ->
                kotlinInfoRemoteKeysDao.getRemoteKey(id = kotlinInfo.id)
            }
    }


}