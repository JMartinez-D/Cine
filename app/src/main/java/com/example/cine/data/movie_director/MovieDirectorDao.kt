package com.example.cine.data.movie_director

import androidx.room.*
import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.cine.data.directors.Director
import com.example.cine.data.movies.Movie

@Dao
interface MovieDirectorDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(crossRef: MovieDirectorCrossRef)

    @Delete
    suspend fun delete(crossRef: MovieDirectorCrossRef)

    @Transaction
    @Query("SELECT * FROM movies WHERE movieId = :movieId")
    suspend fun getMovieWithDirectors(movieId: Long): MovieWithDirectors
}

data class MovieWithDirectors(
    @Embedded val movie: Movie,
    @Relation(
        parentColumn = "movieId",
        entityColumn = "directorId",
        associateBy = Junction(MovieDirectorCrossRef::class)
    )
    val directors: List<Director>
)