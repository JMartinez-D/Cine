package com.example.cine.data.seats

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface SeatDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(seat: Seat): Long

    @Update
    suspend fun update(seat: Seat)

    @Delete
    suspend fun delete(seat: Seat)

    @Query("SELECT * FROM seats WHERE screenId = :screenId ORDER BY row, number")
    fun getByScreen(screenId: Long): Flow<List<Seat>>

    @Query("SELECT * FROM seats WHERE seatId = :id")
    suspend fun getById(id: Long): Seat?
}