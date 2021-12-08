package com.example.numberguessinggame


import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.util.*
import android.content.Intent
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_secondary.*
import kotlinx.android.synthetic.main.activity_preferences.*
import java.io.FileOutputStream
import java.lang.Exception



// This program allows the user to guess a number
class SecondaryActivity : AppCompatActivity(), View.OnClickListener {

    val RANDOM = Random()
    private var message: TextView? = null
    private var numberGuess: EditText? = null
    private var guess: Button? = null
    private var correctNumber = 0
    private var numberOfTries = 0
    var numberOfWins = 0
    var file = "hello_file"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secondary)
        message = findViewById<View>(R.id.message) as TextView
        numberGuess = findViewById<View>(R.id.numberGuess) as EditText
        guess = findViewById<View>(R.id.guess) as Button
        guess!!.setOnClickListener(this)
        newGame()

        // Displays what number range to guess from
        val diff = intent.getIntExtra("difficulty", 25)
        textView.setText  ("Guess a number   1 - " + diff)

        // Save the user's number of wins
        btnSave.setOnClickListener {
            try {
                var fOut:FileOutputStream = openFileOutput(file, Context.MODE_PRIVATE)
                fOut.write(numberOfWins.toString().toByteArray(Charsets.UTF_8))
                fOut.close()
            }
            catch (e:Exception){
                e.printStackTrace()
            }
        }
        // Load the user's number of wins
        loadBtn.setOnClickListener{
            try {
                val fin = openFileInput(file)
                var temp=""
                var bytes:ByteArray = fin.readBytes()

                for(byte in bytes){
                    temp +=byte.toChar()
                }
                winsText.setText("Your wins: " + temp)
            }
            catch (e:Exception){
                e.printStackTrace()
            }
        }

    }


    // On click go to guess class
    override fun onClick(view: View) {
        if (view === guess) {
            guess()
        }
    }

    // This class checks if the number is right or wrong
     private fun guess() {
        val n = numberGuess!!.text.toString().toInt()
        // count the number of tries
        numberOfTries++
        // Allows the second activity to display user's name
        var name = intent.getStringExtra("name")
        // Displays text if the guess was correct
        if (n == correctNumber) {
            numberOfWins++
            // Shows winning text
            message!!.setText("")
            Toast.makeText(
                this, "Congratulations " + name + ", you guessed the number " + correctNumber +
                        " in " + numberOfTries + " tries!", Toast.LENGTH_LONG
            ).show()
            // Starts new game
            newGame()
        }
        // If the guess is wrong it displays that number is too high
        else if (n > correctNumber) {
            message!!.setText("The number is too high")
            val Intent = Intent(this, PreferencesActivity::class.java)
            Intent.putExtra("wins", numberOfWins)
        }
        // If the guess is wrong it displays that number is too low
        else if (n < correctNumber) {
            message!!.setText("The number is too low")
        }
        // The user is limited to three guesses
        if (numberOfTries == 30) {
            message!!.setText("You are out of guesses. The correct number was " + correctNumber)
            // Starts new game
            newGame()
        }
    }

    // Create a new game
    private fun newGame() {
        val diff = intent.getIntExtra("difficulty", 25)
        var MAX_NUMBER = diff
        correctNumber = RANDOM.nextInt(MAX_NUMBER) + 1
        // Erase text after new game
        numberGuess!!.setText("")
        numberOfTries = 0
    }

    // Goes to main
    fun goToMain(view: View?) {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("wins", numberOfWins.toString())
        startActivity(intent)
    }

    // Goes to game
    fun goToGame(view: View?) {
        val intent = Intent(this, SecondaryActivity::class.java)
        intent.putExtra("wins", numberOfWins.toString())
        startActivity(intent)
    }

    // Goes to preferences
    fun goToPreferences(view: View?) {
        val intent = Intent(this, PreferencesActivity::class.java)
        intent.putExtra("wins", numberOfWins.toString())
        startActivity(intent)
    }

    // Goes to help
    fun goToHelp(view: View?) {
        val intent = Intent(this, HelpActivity::class.java)
        intent.putExtra("wins", numberOfWins.toString())
        startActivity(intent)
    }
}
