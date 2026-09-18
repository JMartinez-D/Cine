package com.example.cine.data.showtimes

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.example.cine.data.movies.Movie
import com.example.cine.data.screens.Screen

@Entity(
    tableName = "showtimes",
    foreignKeys = [
        ForeignKey(
            entity = Movie::class,
            parentColumns = ["movieId"],
            childColumns = ["movieId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Screen::class,
            parentColumns = ["screenId"],
            childColumns = ["screenId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("movieId"), Index("screenId")]
)
data class Showtime(
    @PrimaryKey(autoGenerate = true) val showtimeId: Long = 0,
    val movieId: Long,
    val screenId: Long,
    val startTime: String,
    val price: Double
)