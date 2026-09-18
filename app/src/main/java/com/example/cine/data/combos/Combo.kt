package com.example.cine.data.combos

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "combos")
data class Combo(
    @PrimaryKey(autoGenerate = true) val comboId: Long = 0,
    val name: String,
    val price: Double
)