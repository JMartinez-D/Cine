package com.example.cine.data.screens

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.example.cine.data.branches.Branch

@Entity(
    tableName = "screens",
    foreignKeys = [
        ForeignKey(
            entity = Branch::class,
            parentColumns = ["branchId"],
            childColumns = ["branchId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("branchId")]
)
data class Screen(
    @PrimaryKey(autoGenerate = true) val screenId: Long = 0,
    val branchId: Long,
    val name: String,
    val screenType: String // "2D", "3D", "IMAX"
)