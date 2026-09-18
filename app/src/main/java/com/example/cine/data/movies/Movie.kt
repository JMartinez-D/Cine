package com.example.cine.data.movies

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies")
data class Movie(
    @PrimaryKey(autoGenerate = true) val movieId: Long = 0,
    val title: String,
    val durationMinutes: Int,
    val genre: String,
    val synopsis: String,
    val releaseDate: String,
    val posterUrl: String? = null
)