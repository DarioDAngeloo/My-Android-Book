package com.example.myandroidbook.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.myandroidbook.util.Constants.KOTLIN_REMOTE_DATABASE_TABLE

@Entity(tableName = KOTLIN_REMOTE_DATABASE_TABLE)
data class KotlinRemoteKeys(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val prevPage: Int?,
    val nextPage: Int?
)