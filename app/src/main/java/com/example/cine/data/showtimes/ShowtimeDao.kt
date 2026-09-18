package com.example.cine.data.showtimes

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface ShowtimeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(showtime: Showtime): Long

    @Update
    suspend fun update(showtime: Showtime)

    @Delete
    suspend fun delete(showtime: Showtime)

    @Query("SELECT * FROM showtimes WHERE movieId = :movieId")
    fun getByMovie(movieId: Long): Flow<List<Showtime>>

    @Query("SELECT * FROM showtimes WHERE screenId = :screenId")
    fun getByScreen(screenId: Long): Flow<List<Showtime>>

    @Query("SELECT * FROM showtimes WHERE showtimeId = :id")
    suspend fun getById(id: Long): Showtime?
}