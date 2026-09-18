package com.example.cine.data.movie_actor

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import com.example.cine.data.actors.Actor
import com.example.cine.data.movies.Movie

@Entity(
    tableName = "movie_actor",
    primaryKeys = ["movieId", "actorId"],
    foreignKeys = [
        ForeignKey(
            entity = Movie::class,
            parentColumns = ["movieId"],
            childColumns = ["movieId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Actor::class,
            parentColumns = ["actorId"],
            childColumns = ["actorId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("actorId")]
)
data class MovieActorCrossRef(
    val movieId: Long,
    val actorId: Long,
    val characterName: String? = null
)