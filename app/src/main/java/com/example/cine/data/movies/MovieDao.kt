package com.example.cine.data.movies

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(movie: Movie): Long

    @Update
    suspend fun update(movie: Movie)

    @Delete
    suspend fun delete(movie: Movie)

    @Query("SELECT * FROM movies ORDER BY title ASC")
    fun getAll(): Flow<List<Movie>>

    @Query("SELECT * FROM movies WHERE movieId = :id")
    suspend fun getById(id: Long): Movie?
}