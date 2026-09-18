package com.example.cine.data.seats

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.example.cine.data.screens.Screen

@Entity(
    tableName = "seats",
    foreignKeys = [
        ForeignKey(
            entity = Screen::class,
            parentColumns = ["screenId"],
            childColumns = ["screenId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("screenId")]
)
data class Seat(
    @PrimaryKey(autoGenerate = true) val seatId: Long = 0,
    val screenId: Long,
    val row: String,
    val number: Int
)