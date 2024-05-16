package com.nahom.myanimalkingdom.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.nahom.myanimalkingdom.model.Species

@Dao
interface SpeciesDao {
    @Query("SELECT * FROM species")
    fun getAllSpecies(): LiveData<List<Species>>

    @Insert
    suspend fun insert(species: Species)
}
