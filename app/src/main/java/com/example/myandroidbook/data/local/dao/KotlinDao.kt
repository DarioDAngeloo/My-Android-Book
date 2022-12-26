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
    fun getAllHeroes(): PagingSource<Int, KotlinModel>

    @Query("SELECT * FROM kotlin_database WHERE id=:heroId")
    fun getSelectedHero(heroId: Int): KotlinModel

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addHeroes(heroes: List<KotlinModel>)

    @Query("DELETE FROM kotlin_database")
    suspend fun deleteAllHeroes()

}