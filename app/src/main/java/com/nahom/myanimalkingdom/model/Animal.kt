package com.nahom.myanimalkingdom.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "animal")
data class Animal(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String,
    val habitat: String,
    val diet: String
)