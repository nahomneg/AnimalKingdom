package com.nahom.myanimalkingdom.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.nahom.myanimalkingdom.db.AppDatabase
import com.nahom.myanimalkingdom.model.Species
import kotlinx.coroutines.launch

class SpeciesViewModel(application: Application) : AndroidViewModel(application) {
    private val speciesDao = AppDatabase.getDatabase(application).speciesDao()
    val allSpecies: LiveData<List<Species>> = speciesDao.getAllSpecies()

    fun addSpecies(species: Species) = viewModelScope.launch {
        speciesDao.insert(species)
    }
}
