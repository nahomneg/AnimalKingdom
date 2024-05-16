package com.nahom.myanimalkingdom.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "species")
data class Species(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String,
    val description: String
)