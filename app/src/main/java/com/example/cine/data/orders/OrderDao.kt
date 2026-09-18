package com.example.cine.data.orders

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface OrderDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(order: Order): Long

    @Update
    suspend fun update(order: Order)

    @Delete
    suspend fun delete(order: Order)

    @Query("SELECT * FROM orders WHERE userId = :userId ORDER BY orderDate DESC")
    fun getByUser(userId: Long): Flow<List<Order>>

    @Query("SELECT * FROM orders WHERE orderId = :id")
    suspend fun getById(id: Long): Order?
}