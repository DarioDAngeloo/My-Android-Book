package com.example.myandroidbook.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.myandroidbook.util.Constants.KOTLIN_DATABASE_TABLE
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = KOTLIN_DATABASE_TABLE)
data class KotlinModel (
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val title: String,
    val image: String,
    val about: String,
    val tags : List<String>,
    val ranking: Int,
    val yearRelease: Int,
    val difficulty : String
)