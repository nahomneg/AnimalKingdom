package com.nahom.myanimalkingdom.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.nahom.myanimalkingdom.db.AppDatabase
import com.nahom.myanimalkingdom.model.Animal
import kotlinx.coroutines.launch

class AnimalViewModel(application: Application) : AndroidViewModel(application) {
    private val animalDao = AppDatabase.getDatabase(application).animalDao()

    fun getAnimalsForSpecies(): LiveData<List<Animal>> = animalDao.getAnimalsForSpecies()

    fun addAnimal(animal: Animal) = viewModelScope.launch {
        animalDao.insert(animal)
    }
}