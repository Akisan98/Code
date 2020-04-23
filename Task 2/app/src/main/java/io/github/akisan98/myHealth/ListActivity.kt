package io.github.akisan98.myHealth

import android.annotation.SuppressLint
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ramotion.fluidslider.FluidSlider

class ListActivity : AppCompatActivity() {

    val symtomer = ArrayList<Symtoms>()

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)

        if (intent.getStringExtra("seekBar") != null)
        {
            symtomer.add(Symtoms("Coughing", intent.getStringExtra("seekBar").toInt()))
            symtomer.add(Symtoms("Breathing pain", intent.getStringExtra("seekBar2").toInt()))
            symtomer.add(Symtoms("Ithcy Eyes", intent.getStringExtra("seekBar3").toInt()))
        }
        else
        {
            symtomer.add(Symtoms("Coughing", 2))
            symtomer.add(Symtoms("Breathing pain", 3))
            symtomer.add(Symtoms("Ithcy Eyes", 5))
        }
        //symtomer.add(Symtoms("Stroke", 10))


        val adapter = ListAdapter(symtomer)
        recyclerView.adapter = adapter

        fun dialogCaller()
        {
            val dialog = AlertDialog.Builder(this)
            val dialogView = layoutInflater.inflate(R.layout.answer_dialog, null)
            val name = dialogView.findViewById<EditText>(R.id.editText)
            val value = dialogView.findViewById<FluidSlider>(R.id.fluidSlider4)

            //Definerer Custom start og slutt verdi på slideren
            val start = 1
            val end = 10

            value.startText = start.toString()
            value.endText = end.toString()
            value.position = 0.0f
            value.bubbleText = 1.toString()

            value.positionListener = {
                    pos -> value.bubbleText = (start + (end-start)*pos).toInt().toString()
            }

            dialog.setView(dialogView)

            dialog.setPositiveButton("Save Symtom", { dialogInterface: DialogInterface, i: Int -> })
            dialog.setNegativeButton("Cancel") { dialogInterface: DialogInterface, i: Int ->
                Toast.makeText(applicationContext, "Canceled due to User-Request", Toast.LENGTH_SHORT).show()}

            val answer = dialog.create()
            answer.show()

            answer.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener {
                if (name.length() > 0) {
                    symtomer.add(Symtoms(name.getText().toString(), (start + ((end - start) * value.position)).toInt() ))
                } else
                    Toast.makeText(getApplicationContext(), "Canceled due to No Input!!", Toast.LENGTH_SHORT).show()
                answer.dismiss()
            }
        }

        val fab: View = findViewById(R.id.floatingActionButton)
        fab.setOnClickListener{view ->
            /*Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_SHORT)
                .setAction("Action", null)
                .show()*/
            //Toast.makeText(getApplicationContext(), "Registert trykk, ingen handing", Toast.LENGTH_SHORT).show()
            dialogCaller()
        }


    }
}
