package com.nahom.myanimalkingdom.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.nahom.myanimalkingdom.dao.AnimalDao
import com.nahom.myanimalkingdom.dao.SpeciesDao
import com.nahom.myanimalkingdom.model.Animal
import com.nahom.myanimalkingdom.model.Species

@Database(entities = [Species::class, Animal::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun speciesDao(): SpeciesDao
    abstract fun animalDao(): AnimalDao

    companion object {
        @Volatile private var instance: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase =
            instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "animal_kingdom.db").build()
    }
}
