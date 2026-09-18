package com.example.cine.data.tickets

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.example.cine.data.orders.Order
import com.example.cine.data.seats.Seat
import com.example.cine.data.showtimes.Showtime

@Entity(
    tableName = "tickets",
    foreignKeys = [
        ForeignKey(
            entity = Showtime::class,
            parentColumns = ["showtimeId"],
            childColumns = ["showtimeId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Seat::class,
            parentColumns = ["seatId"],
            childColumns = ["seatId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Order::class,
            parentColumns = ["orderId"],
            childColumns = ["orderId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("showtimeId"), Index("seatId"), Index("orderId")]
)
data class Ticket(
    @PrimaryKey(autoGenerate = true) val ticketId: Long = 0,
    val showtimeId: Long,
    val seatId: Long,
    val orderId: Long,
    val price: Double
)