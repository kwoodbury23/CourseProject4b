package com.example.numberguessinggame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_preferences.*


// Preferences allows the user to view wins and change the difficulty
class PreferencesActivity : AppCompatActivity() {
    var diff = 0
    var file = "diff_file"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preferences)

    }

    // Goes to main
    fun goToMain(view: View?) {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("difficulty", diff)
        startActivity(intent)
    }

    // Goes to game
    fun goToGame(view: View?) {
        val intent = Intent(this, SecondaryActivity::class.java)
        startActivity(intent)
    }

    // Goes to preferences
    fun goToPreferences(view: View?) {
        val intent = Intent(this, PreferencesActivity::class.java)
        intent.putExtra("difficulty", diff)
        startActivity(intent)
    }

    // Goes to help
    fun goToHelp(view: View?) {
        val intent = Intent(this, HelpActivity::class.java)
        intent.putExtra("difficulty", diff)
        startActivity(intent)
    }

    // Changes the difficulty of the game
    fun changeDifficulty(view: View?) {

        when {
            easyB.isChecked -> diff = 25
            normalB.isChecked -> diff = 50
            hardB.isChecked -> diff = 100
        }

    }

    // Saves the difficulty of the game
    fun saveChanges(view: View?) {
        val intent = Intent(this, SecondaryActivity::class.java)
        intent.putExtra("difficulty", diff)
        startActivity(intent)
    }

}




