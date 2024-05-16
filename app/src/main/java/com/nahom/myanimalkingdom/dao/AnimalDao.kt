package com.nahom.myanimalkingdom.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.nahom.myanimalkingdom.model.Animal

@Dao
interface AnimalDao {
    @Query("SELECT * FROM animal WHERE speciesId = :speciesId")
    fun getAnimalsForSpecies(speciesId: Int): LiveData<List<Animal>>

    @Insert
    suspend fun insert(animal: Animal)
}