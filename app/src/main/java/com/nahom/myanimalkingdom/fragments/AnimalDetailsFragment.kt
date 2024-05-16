package com.nahom.myanimalkingdom.fragments

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.nahom.myanimalkingdom.R
import com.nahom.myanimalkingdom.dao.AnimalDao
import com.nahom.myanimalkingdom.model.Animal
import com.nahom.myanimalkingdom.repository.AnimalRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AnimalDetailsFragment(private val animalDao: AnimalDao) : Fragment() {

    private val animalRepository = AnimalRepository(animalDao) // Initialize your repository here

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_animal_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fab = view.findViewById<com.google.android.material.floatingactionbutton.FloatingActionButton>(R.id.fab_add_animal)
        fab.setOnClickListener {
            showAddAnimalDialog()
        }
    }

    private fun showAddAnimalDialog() {
        val dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_add_animal, null)
        val nameEditText = dialogView.findViewById<EditText>(R.id.edit_text_animal_name)
        val habitatEditText = dialogView.findViewById<EditText>(R.id.edit_text_animal_habitat)
        val dietEditText = dialogView.findViewById<EditText>(R.id.edit_text_animal_diet)

        AlertDialog.Builder(context)
            .setTitle("Add Animal")
            .setView(dialogView)
            .setPositiveButton("Add") { _, _ ->
                val name = nameEditText.text.toString()
                val habitat = habitatEditText.text.toString()
                val diet = dietEditText.text.toString()

                if (name.isNotBlank() && habitat.isNotBlank() && diet.isNotBlank()) {
                    val newAnimal = Animal(0,name = name, habitat = habitat, diet = diet)
                    addAnimalToDatabase(newAnimal)
                } else {
                    // Show validation error message
                }
            }
            .setNegativeButton("Cancel", null)
            .show()
    }

    private fun addAnimalToDatabase(animal: Animal) {
        CoroutineScope(Dispatchers.IO).launch {
            animalRepository.insert(animal)
        }
    }
}
