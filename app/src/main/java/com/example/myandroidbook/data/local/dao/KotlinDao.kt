package com.example.myandroidbook.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myandroidbook.domain.model.KotlinModel


@Dao
interface KotlinDao {

    @Query("SELECT * FROM kotlin_database ORDER BY id ASC")
    fun getAllKotlinInfo(): PagingSource<Int, KotlinModel>

    @Query("SELECT * FROM kotlin_database WHERE id=:kotlinId")
    fun getSelectedKotlinInfo(kotlinId: Int): KotlinModel

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addKotlinInfo(koltlinList: List<KotlinModel>)

    @Query("DELETE FROM kotlin_database")
    suspend fun deleteAllKotlinInfo()

}