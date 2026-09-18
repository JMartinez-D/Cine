package com.example.cine.data.combo_item

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import com.example.cine.data.combos.Combo
import com.example.cine.data.items.Item

@Entity(
    tableName = "combo_item",
    primaryKeys = ["comboId", "itemId"],
    foreignKeys = [
        ForeignKey(
            entity = Combo::class,
            parentColumns = ["comboId"],
            childColumns = ["comboId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Item::class,
            parentColumns = ["itemId"],
            childColumns = ["itemId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("itemId")]
)
data class ComboItemCrossRef(
    val comboId: Long,
    val itemId: Long,
    val quantity: Int = 1
)