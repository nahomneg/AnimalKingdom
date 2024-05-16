package com.nahom.myanimalkingdom


import android.os.Bundle
import android.view.View.INVISIBLE
import android.widget.Button
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.nahom.myanimalkingdom.db.AppDatabase
import com.nahom.myanimalkingdom.fragments.AnimalDetailsFragment


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnAnimalDetails = findViewById<Button>(R.id.btnAnimalDetails)
        val btnSpeciesDetails = findViewById<Button>(R.id.btnSpeciesDetails)
        val linearContainer = findViewById<RelativeLayout>(R.id.linearContainer)
        linearContainer.visibility
        btnAnimalDetails.setOnClickListener {
            openFragment(AnimalDetailsFragment(AppDatabase.getDatabase(application).animalDao()), linearContainer)
        }

//        btnSpeciesDetails.setOnClickListener {
//            openFragment(SpeciesDetailsFragment())
//        }
    }

    private fun openFragment(fragment: Fragment, container:RelativeLayout) {
       container.visibility = INVISIBLE
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, fragment)
            addToBackStack(null)
            commit()
        }
    }
}