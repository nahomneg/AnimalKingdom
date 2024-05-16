package com.nahom.myanimalkingdom.repository

import com.nahom.myanimalkingdom.dao.AnimalDao
import com.nahom.myanimalkingdom.model.Animal

class AnimalRepository(private val animalDao: AnimalDao) {
    suspend fun insert(animal: Animal) {
        animalDao.insert(animal)
    }
}