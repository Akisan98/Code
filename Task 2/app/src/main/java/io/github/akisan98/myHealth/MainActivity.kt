package io.github.akisan98.myHealth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.view.View


class MainActivity : AppCompatActivity() {
    // 3 slidere for symtomer input

    lateinit var seekBar: SeekBar
    lateinit var seekBar2: SeekBar
    lateinit var seekBar3: SeekBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Tildeler slidere en variabel-navn/id
        seekBar = findViewById(R.id.seekBar)
        seekBar2 = findViewById(R.id.seekBar2)
        seekBar3 = findViewById(R.id.seekBar3)
    }

    fun neste(view : View)
    {
        // + 1 siden skalaen går mellom 0 og 9 siden dottene i skalene følger max verdi,
        // derfor har jeg ikke satt max til 10 og min til 1.

        val intent = Intent(this, SecoundScreen::class.java).apply {
            putExtra("seekBar", (seekBar.progress + 1).toString())
            putExtra("seekBar2", (seekBar2.progress + 1).toString())
            putExtra("seekBar3", (seekBar3.progress + 1).toString())
        }
        startActivity(intent)
    }

    fun neste2(view : View)
    {
        // + 1 siden skalaen går mellom 0 og 9 siden dottene i skalene følger max verdi,
        // derfor har jeg ikke satt max til 10 og min til 1.

        val intent = Intent(this, ListActivity::class.java).apply {
            putExtra("seekBar", (seekBar.progress + 1).toString())
            putExtra("seekBar2", (seekBar2.progress + 1).toString())
            putExtra("seekBar3", (seekBar3.progress + 1).toString())
        }
        startActivity(intent)
    }

    //Hva som skjer når man trykker på info-ikonet
    //Åpener ny skjerm med info-beskrivelse
    fun infoscreen(view : View)
    {
        val intent = Intent(this, InformationScreen::class.java)
        startActivity(intent)
    }

    //Hva som skjer når man trykker på custom-knappen
    //Åpener ny skjerm med custom-input...
    fun customSliders(view : View)
    {
        val intent = Intent(this, InputFromUser::class.java)
        startActivity(intent)
    }

}
