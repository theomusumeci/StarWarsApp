package com.starwars.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Character(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "first_name") val firstName: String,
)
