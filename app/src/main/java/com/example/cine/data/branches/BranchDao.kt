package com.example.cine.data.branches

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface BranchDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(branch: Branch): Long

    @Update
    suspend fun update(branch: Branch)

    @Delete
    suspend fun delete(branch: Branch)

    @Query("SELECT * FROM branches ORDER BY name ASC")
    fun getAll(): Flow<List<Branch>>

    @Query("SELECT * FROM branches WHERE branchId = :id")
    suspend fun getById(id: Long): Branch?
}