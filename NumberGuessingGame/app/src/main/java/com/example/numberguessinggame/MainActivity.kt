package com.example.numberguessinggame


import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_login.*



// This program allows the user to enter a name for the game
class MainActivity : AppCompatActivity() {


    override fun onCreate(sharedPreferences: Bundle?) {
        super.onCreate(sharedPreferences)
        setContentView(R.layout.activity_main)

    }

    // Allows the user to go to the second activity
    fun sendMessage(view: View?) {
        val intent = Intent(this, SecondaryActivity::class.java)
        // Allows the second activity to display user's name
        intent.putExtra("name", editName.text.toString())
        startActivity(intent)
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