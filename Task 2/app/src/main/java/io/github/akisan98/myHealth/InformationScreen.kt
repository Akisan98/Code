package io.github.akisan98.myHealth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class InformationScreen : AppCompatActivity() {
    lateinit var backButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_information_screen)

        backButton = findViewById(R.id.button6)

        //Definerer hva den skal gjør om man trykker på tilbake-pilen
        backButton.setOnClickListener {
            //Kaller bare på Android-system sin tilbake funksjon/knapp
            onBackPressed()
        }
    }
}
