package com.example.cine.data.users

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: User): Long

    @Update
    suspend fun update(user: User)

    @Delete
    suspend fun delete(user: User)

    @Query("SELECT * FROM users ORDER BY name ASC")
    fun getAll(): Flow<List<User>>

    @Query("SELECT * FROM users WHERE userId = :id")
    suspend fun getById(id: Long): User?

    @Query("SELECT * FROM users WHERE email = :email LIMIT 1")
    suspend fun getByEmail(email: String): User?
}