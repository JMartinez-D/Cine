package com.example.cine.data.screens

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface ScreenDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(screen: Screen): Long

    @Update
    suspend fun update(screen: Screen)

    @Delete
    suspend fun delete(screen: Screen)

    @Query("SELECT * FROM screens WHERE branchId = :branchId")
    fun getByBranch(branchId: Long): Flow<List<Screen>>

    @Query("SELECT * FROM screens WHERE screenId = :id")
    suspend fun getById(id: Long): Screen?
}