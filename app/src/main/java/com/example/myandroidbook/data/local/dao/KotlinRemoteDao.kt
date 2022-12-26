package com.example.myandroidbook.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myandroidbook.domain.model.KotlinRemoteKey

@Dao
interface KotlinRemoteDao {

    @Query("SELECT * FROM kotlin_remote_database WHERE id = :id")
    suspend fun getRemoteKey(id: Int): KotlinRemoteKey?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAllRemoteKeys(heroRemoteKeys: List<KotlinRemoteKey>)

    @Query("DELETE FROM kotlin_remote_database")
    suspend fun deleteAllRemoteKeys()

}