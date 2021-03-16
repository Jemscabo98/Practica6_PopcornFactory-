package montoya.eduardo.practica6_popcornfactory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class SeatSelection : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seat_selection)

        var title: TextView = findViewById(R.id.titleSeat)
        val btnConfirm: Button =findViewById(R.id.btnConfirm)
        var posMovie = -1

        val bundle = intent.extras

        if (bundle!=null)
        {
            title.setText(bundle.getString("titulo"))
            posMovie = bundle.getInt("id")
        }

        btnConfirm.setOnClickListener{
            //Añadir logica para reservar el lugar seleccionado por el usuario
            // Hacer una nueva actividad donde se vea el resumen de la compra es decir que se..
            // agregue el nombre del cliente y se vea el asiento que se selecciono

            Toast.makeText(this, "Prueba", Toast.LENGTH_SHORT).show()
        }

        val row1: RadioGroup = findViewById(R.id.row1)
        val row2: RadioGroup = findViewById(R.id.row2)
        val row3: RadioGroup = findViewById(R.id.row3)
        val row4: RadioGroup = findViewById(R.id.row4)

        row1.setOnCheckedChangeListener { group, checkedId ->

            if (checkedId > -1) {
                row2.clearCheck()
                row3.clearCheck()
                row4.clearCheck()

                row1.check(checkedId)
            }
        }

        row2.setOnCheckedChangeListener { group, checkedId ->

            if (checkedId > -1) {
                row1.clearCheck()
                row3.clearCheck()
                row4.clearCheck()

                row2.check(checkedId)
            }
        }

        row3.setOnCheckedChangeListener { group, checkedId ->

            if (checkedId > -1) {
                row1.clearCheck()
                row2.clearCheck()
                row4.clearCheck()

                row3.check(checkedId)
            }
        }

        row4.setOnCheckedChangeListener { group, checkedId ->

            if (checkedId > -1) {
                row1.clearCheck()
                row2.clearCheck()
                row3.clearCheck()

                row4.check(checkedId)
            }
        }
    }
}