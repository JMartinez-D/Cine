package com.example.cine.data.directors

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "directors")
data class Director(
    @PrimaryKey(autoGenerate = true) val directorId: Long = 0,
    val name: String,
    val nationality: String? = null,
    val bio: String? = null
)