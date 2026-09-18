package com.example.cine.data.order_item

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import com.example.cine.data.items.Item
import com.example.cine.data.orders.Order

@Entity(
    tableName = "order_item",
    primaryKeys = ["orderId", "itemId"],
    foreignKeys = [
        ForeignKey(
            entity = Order::class,
            parentColumns = ["orderId"],
            childColumns = ["orderId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Item::class,
            parentColumns = ["itemId"],
            childColumns = ["itemId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("itemId")]
)
data class OrderItem(
    val orderId: Long,
    val itemId: Long,
    val quantity: Int,
    val unitPrice: Double
)