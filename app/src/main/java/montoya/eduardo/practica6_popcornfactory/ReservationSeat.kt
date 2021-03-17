package montoya.eduardo.practica6_popcornfactory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class ReservationSeat : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reservation_seat)

        var movieTitle: TextView = findViewById(R.id.movieTitle)
        var seatNumber: TextView = findViewById(R.id.seatNumber)
        var btnMenu: Button = findViewById(R.id.btnMenu)

        val bundle = intent.extras

        if (bundle!=null)
        {
            movieTitle.setText(bundle.getString("movie"))

            var aux: String = bundle.getString("seat")!!
            seatNumber.setText(aux)
        }

        btnMenu.setOnClickListener{
            val intent: Intent = Intent(this, MenuActivity::class.java)

            this.startActivity(intent)
        }


    }
}