package com.example.cine.data.order_item

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface OrderItemDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(orderItem: OrderItem)

    @Delete
    suspend fun delete(orderItem: OrderItem)

    @Query("SELECT * FROM order_item WHERE orderId = :orderId")
    fun getByOrder(orderId: Long): Flow<List<OrderItem>>
}