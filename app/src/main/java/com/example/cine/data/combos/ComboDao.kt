package com.example.cine.data.combos

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface ComboDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(combo: Combo): Long

    @Update
    suspend fun update(combo: Combo)

    @Delete
    suspend fun delete(combo: Combo)

    @Query("SELECT * FROM combos ORDER BY name ASC")
    fun getAll(): Flow<List<Combo>>

    @Query("SELECT * FROM combos WHERE comboId = :id")
    suspend fun getById(id: Long): Combo?
}