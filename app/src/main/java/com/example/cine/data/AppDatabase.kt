package com.example.cine.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

import com.example.cine.data.movies.Movie
import com.example.cine.data.movies.MovieDao
import com.example.cine.data.directors.Director
import com.example.cine.data.directors.DirectorDao
import com.example.cine.data.actors.Actor
import com.example.cine.data.actors.ActorDao
import com.example.cine.data.movie_director.MovieDirectorCrossRef
import com.example.cine.data.movie_director.MovieDirectorDao
import com.example.cine.data.movie_actor.MovieActorCrossRef
import com.example.cine.data.movie_actor.MovieActorDao
import com.example.cine.data.branches.Branch
import com.example.cine.data.branches.BranchDao
import com.example.cine.data.screens.Screen
import com.example.cine.data.screens.ScreenDao
import com.example.cine.data.seats.Seat
import com.example.cine.data.seats.SeatDao
import com.example.cine.data.showtimes.Showtime
import com.example.cine.data.showtimes.ShowtimeDao
import com.example.cine.data.tickets.Ticket
import com.example.cine.data.tickets.TicketDao
import com.example.cine.data.items.Item
import com.example.cine.data.items.ItemDao
import com.example.cine.data.combos.Combo
import com.example.cine.data.combos.ComboDao
import com.example.cine.data.combo_item.ComboItemCrossRef
import com.example.cine.data.combo_item.ComboItemDao
import com.example.cine.data.users.User
import com.example.cine.data.users.UserDao
import com.example.cine.data.orders.Order
import com.example.cine.data.orders.OrderDao
import com.example.cine.data.order_item.OrderItem
import com.example.cine.data.order_item.OrderItemDao

@Database(
    entities = [
        Movie::class, Director::class, Actor::class,
        MovieDirectorCrossRef::class, MovieActorCrossRef::class,
        Branch::class, Screen::class, Seat::class, Showtime::class,
        Ticket::class, Item::class, Combo::class, ComboItemCrossRef::class,
        User::class, Order::class, OrderItem::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
    abstract fun directorDao(): DirectorDao
    abstract fun actorDao(): ActorDao
    abstract fun movieDirectorDao(): MovieDirectorDao
    abstract fun movieActorDao(): MovieActorDao
    abstract fun branchDao(): BranchDao
    abstract fun screenDao(): ScreenDao
    abstract fun seatDao(): SeatDao
    abstract fun showtimeDao(): ShowtimeDao
    abstract fun ticketDao(): TicketDao
    abstract fun itemDao(): ItemDao
    abstract fun comboDao(): ComboDao
    abstract fun comboItemDao(): ComboItemDao
    abstract fun userDao(): UserDao
    abstract fun orderDao(): OrderDao
    abstract fun orderItemDao(): OrderItemDao

    companion object {
        @Volatile private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "cine_database"
                ).build().also { INSTANCE = it }
            }
    }
}