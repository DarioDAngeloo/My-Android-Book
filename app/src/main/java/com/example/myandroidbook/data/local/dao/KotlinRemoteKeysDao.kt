package com.example.myandroidbook.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myandroidbook.domain.model.KotlinRemoteKeys

@Dao
interface KotlinRemoteKeysDao {

    @Query("SELECT * FROM kotlin_remote_database WHERE id = :id")
    suspend fun getRemoteKey(id: Int): KotlinRemoteKeys?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAllRemoteKeys(kotlinRemoteKeys: List<KotlinRemoteKeys>)

    @Query("DELETE FROM kotlin_remote_database")
    suspend fun deleteAllRemoteKeys()

}