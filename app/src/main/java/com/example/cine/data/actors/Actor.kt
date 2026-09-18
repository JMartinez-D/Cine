package com.example.cine.data.actors

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "actors")
data class Actor(
    @PrimaryKey(autoGenerate = true) val actorId: Long = 0,
    val name: String,
    val nationality: String? = null,
    val bio: String? = null
)