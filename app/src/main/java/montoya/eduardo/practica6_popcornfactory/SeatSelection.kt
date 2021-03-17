package montoya.eduardo.practica6_popcornfactory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.core.view.get
import java.util.*
import kotlin.collections.ArrayList

class SeatSelection : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seat_selection)

        val title: TextView = findViewById(R.id.titleSeat)
        val btnConfirm: Button =findViewById(R.id.btnConfirm)
        var movie = ""
        var seats = -1

        val bundle = intent.extras

        if (bundle!=null)
        {
            title.setText(bundle.getString("movie"))
            movie = bundle.getString("movie")!!
            seats = bundle.getInt("seats")
        }

        btnConfirm.setOnClickListener{
            var seat_selected = seat_selection()

            val intent: Intent = Intent(this, ReservationSeat::class.java)

            intent.putExtra("movie", movie)
            intent.putExtra("seat", seat_selected.toString())

           // Toast.makeText(this, seat_selected.toString(), Toast.LENGTH_SHORT).show()

            startActivity(intent)

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

        disableButtons(seats)





    }

    fun disableButtons(seatsav: Int)
    {
        val asientos: ArrayList<Int> = ArrayList<Int>()

        for (i in 0 until seatsav){
            asientos.add(1)
        }

        for (i in seatsav until 20)
        {
            asientos.add(0)
        }

        Collections.shuffle(asientos)

        for (i in 0 until 20)
        {
            if (asientos.get(i) == 0) {
                val radioid: String = "seat" + (i + 1)
                val resID: Int = resources.getIdentifier(radioid, "id", packageName)
                val radio: RadioButton = findViewById(resID)
                radio.isEnabled = false

            }
        }
    }

    fun seat_selection(): Int{
        var seat = 0
        for (i in 0 until 20)
        {
            val radioid: String = "seat" + (i+1)
            val resID: Int = resources.getIdentifier(radioid, "id", packageName)
            val radio: RadioButton = findViewById(resID)

            if(radio.isChecked) {
                seat = i + 1
                radio.isEnabled = false
            }
        }

        return seat
    }

}