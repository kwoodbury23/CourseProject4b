package com.example.numberguessinggame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View


// The help activity displays the purpose and information about preferences
class HelpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_help)
    }

    // Goes to main
    fun goToMain(view: View?) {
        val intent = Intent(this, MainActivity::class.java)
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
        startActivity(intent)
    }

    // Goes to help
    fun goToHelp(view: View?) {
        val intent = Intent(this, HelpActivity::class.java)
        startActivity(intent)
    }

}