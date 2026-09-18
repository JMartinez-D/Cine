package com.example.cine.data.directors

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface DirectorDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(director: Director): Long

    @Update
    suspend fun update(director: Director)

    @Delete
    suspend fun delete(director: Director)

    @Query("SELECT * FROM directors ORDER BY name ASC")
    fun getAll(): Flow<List<Director>>

    @Query("SELECT * FROM directors WHERE directorId = :id")
    suspend fun getById(id: Long): Director?
}