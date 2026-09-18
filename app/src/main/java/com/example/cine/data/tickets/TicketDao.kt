package com.example.cine.data.tickets

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface TicketDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(ticket: Ticket): Long

    @Delete
    suspend fun delete(ticket: Ticket)

    @Query("SELECT * FROM tickets WHERE orderId = :orderId")
    fun getByOrder(orderId: Long): Flow<List<Ticket>>

    @Query("SELECT * FROM tickets WHERE showtimeId = :showtimeId")
    fun getByShowtime(showtimeId: Long): Flow<List<Ticket>>
}