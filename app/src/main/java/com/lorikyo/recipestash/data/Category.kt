package com.lorikyo.recipestash.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "category")
data class Category(
    @ColumnInfo(name = "str_category") @PrimaryKey val strCategory: String,
)
