package com.example.myandroidbook.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.myandroidbook.data.local.dao.KotlinDao
import com.example.myandroidbook.data.local.dao.KotlinRemoteKeysDao
import com.example.myandroidbook.domain.model.KotlinModel
import com.example.myandroidbook.domain.model.KotlinRemoteKeys

@Database(entities = [KotlinModel::class, KotlinRemoteKeys::class], version = 1)
@TypeConverters(DatabaseConverter::class)
abstract class KotlinDatabase : RoomDatabase() {

    abstract fun kotlinDao(): KotlinDao
    abstract fun kotlinRemoteKeysDao(): KotlinRemoteKeysDao

}