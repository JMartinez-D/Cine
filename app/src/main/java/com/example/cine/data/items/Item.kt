package com.example.cine.data.items

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "items")
data class Item(
    @PrimaryKey(autoGenerate = true) val itemId: Long = 0,
    val name: String,
    val price: Double,
    val category: String // "snack", "bebida", etc.
)