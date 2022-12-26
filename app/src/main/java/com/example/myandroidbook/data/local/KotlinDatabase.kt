package com.example.myandroidbook.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.myandroidbook.data.local.dao.KotlinDao
import com.example.myandroidbook.data.local.dao.KotlinRemoteDao
import com.example.myandroidbook.domain.model.KotlinModel
import com.example.myandroidbook.domain.model.KotlinRemoteKey

@Database(entities = [KotlinModel::class, KotlinRemoteKey::class], version = 1)
@TypeConverters(DatabaseConverter::class)
abstract class KotlinDatabase : RoomDatabase() {

    abstract fun heroDao(): KotlinDao
    abstract fun heroRemoteKeyDao(): KotlinRemoteDao

}