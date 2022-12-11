package com.lorikyo.recipestash.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "area")
data class Area(
    @ColumnInfo(name = "str_area") @PrimaryKey val strArea: String,
)
