package com.example.cine.data.combo_item

import androidx.room.*
import com.example.cine.data.combos.Combo
import com.example.cine.data.items.Item

@Dao
interface ComboItemDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(crossRef: ComboItemCrossRef)

    @Delete
    suspend fun delete(crossRef: ComboItemCrossRef)

    @Transaction
    @Query("SELECT * FROM combos WHERE comboId = :comboId")
    suspend fun getComboWithItems(comboId: Long): ComboWithItems
}

data class ComboWithItems(
    @Embedded val combo: Combo,
    @Relation(
        parentColumn = "comboId",
        entityColumn = "itemId",
        associateBy = Junction(ComboItemCrossRef::class)
    )
    val items: List<Item>
)