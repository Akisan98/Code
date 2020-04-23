package io.github.akisan98.myHealth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.content.Intent
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import androidx.core.app.NotificationCompat.getExtras
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.view.View
import android.widget.Button


class SecoundScreen : AppCompatActivity() {
    lateinit var tall: TextView
    lateinit var tall2: TextView
    lateinit var tall3: TextView
    lateinit var backButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secound_screen)

        //Tildeler tekst-elementene en variabel-navn
        tall = findViewById<TextView>(R.id.textView13)
        tall2 = findViewById<TextView>(R.id.textView14)
        tall3 = findViewById<TextView>(R.id.textView15)
        backButton = findViewById(R.id.button5)

        //Tildeler tekst til tekst-elementene
        tall.text = intent.getStringExtra("seekBar")
        tall2.text = intent.getStringExtra("seekBar2")
        tall3.text = intent.getStringExtra("seekBar3")

        //Definerer hva den skal gjør om man trykker på tilbake-pilen
        backButton.setOnClickListener {
            //Kaller bare på Android-system sin tilbake funksjon/knapp
            onBackPressed()
        }
    }

    //Hva som skjer når man trykker på info-ikonet
    //Åpener ny skjerm med info-beskrivelse
    fun infoscreen(view : View)
    {
        val intent = Intent(this, InformationScreen::class.java)
        startActivity(intent)
    }
}
