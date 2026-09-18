package com.example.cine.data.movie_director

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import com.example.cine.data.directors.Director
import com.example.cine.data.movies.Movie

@Entity(
    tableName = "movie_director",
    primaryKeys = ["movieId", "directorId"],
    foreignKeys = [
        ForeignKey(
            entity = Movie::class,
            parentColumns = ["movieId"],
            childColumns = ["movieId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Director::class,
            parentColumns = ["directorId"],
            childColumns = ["directorId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("directorId")]
)
data class MovieDirectorCrossRef(
    val movieId: Long,
    val directorId: Long
)