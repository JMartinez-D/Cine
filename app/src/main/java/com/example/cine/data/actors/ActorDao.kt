package com.example.cine.data.actors

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface ActorDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(actor: Actor): Long

    @Update
    suspend fun update(actor: Actor)

    @Delete
    suspend fun delete(actor: Actor)

    @Query("SELECT * FROM actors ORDER BY name ASC")
    fun getAll(): Flow<List<Actor>>

    @Query("SELECT * FROM actors WHERE actorId = :id")
    suspend fun getById(id: Long): Actor?
}