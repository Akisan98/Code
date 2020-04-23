package io.github.akisan98.myHealth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ramotion.fluidslider.FluidSlider
import android.view.View
import android.widget.Button


class InputFromUser : AppCompatActivity() {
    lateinit var slider : FluidSlider
    lateinit var slider2 : FluidSlider
    lateinit var slider3: FluidSlider
    lateinit var backButton : Button

    //Definerer Custom start og slutt verdi på slideren
    val start = 1
    val end = 10

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_from_user)

        //Tildeler slidere en variabel-navn
        slider = findViewById<FluidSlider>(R.id.fluidSlider)
        slider2 = findViewById<FluidSlider>(R.id.fluidSlider2)
        slider3 = findViewById<FluidSlider>(R.id.fluidSlider3)
        backButton = findViewById(R.id.button4)

        //Denne Custom slideren hadde ikke noen enkle XML attruibutter for å sette
        //max og min value, så det er endret her i koden for alle tre slidere
        slider.startText = start.toString()
        slider.endText = end.toString()
        slider.position = 0.0f
        slider.bubbleText = 1.toString()

        //Definerer at den skal oppdaterte tekst verdien på boblen, når bruker drar den
        //Her igjen må jeg skrive litt kode siden den ikke naturlig støtter en slider mellom 1 og 10
        slider.positionListener = {
                pos -> slider.bubbleText = (start + (end-start)*pos).toInt().toString()
        }

        slider2.startText = start.toString()
        slider2.endText = end.toString()
        slider2.position = 0.0f
        slider2.bubbleText = 1.toString()
        slider2.positionListener = {
                pos -> slider2.bubbleText = (start + (end-start)*pos).toInt().toString()
        }

        slider3.startText = start.toString()
        slider3.endText = end.toString()
        slider3.position = 0.0f
        slider3.bubbleText = 1.toString()
        slider3.positionListener = {
                pos -> slider3.bubbleText = (start + (end-start)*pos).toInt().toString()
        }

        //Definerer hva den skal gjør om man trykker på tilbake-pilen
        backButton.setOnClickListener {
            //Kaller bare på Android-system sin tilbake funksjon/knapp
            onBackPressed()
        }
    }

    //Hva som skjer når man trykker på vis resultat
    fun neste(view : View)
    {
        // + 1 siden skalaen går mellom 0 og 9 siden dottene i skalene følger max verdi,
        // derfor har jeg ikke satt max til 10 og min til 1.

        val intent = Intent(this, SecoundScreen::class.java).apply {
            //Her igjen må jeg skrive litt kode siden den ikke naturlig støtter en slider mellom 1 og 10
            //Legger til ekstra verdier vi sender vidre til den "nye skjermen"
            putExtra("seekBar", (start + (end - start) * slider.position).toInt().toString())
            putExtra("seekBar2", (start + (end - start) * slider2.position).toInt().toString())
            putExtra("seekBar3", (start + (end - start) * slider3.position).toInt().toString())
        }
        //Startet den nye skjermen
        startActivity(intent)
    }

    fun neste2(view : View)
    {
        // + 1 siden skalaen går mellom 0 og 9 siden dottene i skalene følger max verdi,
        // derfor har jeg ikke satt max til 10 og min til 1.

        val intent = Intent(this, ListActivity::class.java).apply {
            //Her igjen må jeg skrive litt kode siden den ikke naturlig støtter en slider mellom 1 og 10
            //Legger til ekstra verdier vi sender vidre til den "nye skjermen"
            putExtra("seekBar", (start + (end - start) * slider.position).toInt().toString())
            putExtra("seekBar2", (start + (end - start) * slider2.position).toInt().toString())
            putExtra("seekBar3", (start + (end - start) * slider3.position).toInt().toString())
        }
        //Startet den nye skjermen
        startActivity(intent)
    }

    //Hva som skjer når man trykker på info-ikonet
    //Åpener ny skjerm med info-beskrivelse
    fun infoscreen(view : View)
    {
        val intent = Intent(this, InformationScreen::class.java)
        startActivity(intent)
    }
}
