package com.example.cine.data.items

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: Item): Long

    @Update
    suspend fun update(item: Item)

    @Delete
    suspend fun delete(item: Item)

    @Query("SELECT * FROM items ORDER BY category, name")
    fun getAll(): Flow<List<Item>>

    @Query("SELECT * FROM items WHERE itemId = :id")
    suspend fun getById(id: Long): Item?
}