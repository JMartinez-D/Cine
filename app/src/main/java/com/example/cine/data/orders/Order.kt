package com.example.cine.data.orders

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.example.cine.data.users.User

@Entity(
    tableName = "orders",
    foreignKeys = [
        ForeignKey(
            entity = User::class,
            parentColumns = ["userId"],
            childColumns = ["userId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("userId")]
)
data class Order(
    @PrimaryKey(autoGenerate = true) val orderId: Long = 0,
    val userId: Long,
    val orderDate: String,
    val totalAmount: Double,
    val status: String // "pending", "paid", "cancelled"
)