package montoya.eduardo.practica6_popcornfactory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MovieDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        var img: ImageView = findViewById(R.id.imgDescripcion)
        var name: TextView = findViewById(R.id.txtTituloDescripcion)
        var descrip: TextView = findViewById(R.id.txtDescripcion)
        var seatLeft: TextView = findViewById(R.id.seatsLeft)
        var buyTickets: Button = findViewById(R.id.butTickets)

        val bundle = intent.extras
        var ns = 0
        var id = -1
        var titule = ""

        if (bundle != null)
        {
            ns = bundle.getInt("numberSeats")
            titule = bundle.getString("titulo")!!



            img.setImageResource(bundle.getInt("header"))
            name.setText(bundle.getString("titulo"))
            descrip.setText(bundle.getString("sinopsis"))
            seatLeft.setText("$ns - Seats Available")
            id = bundle.getInt("position")
        }

        if (ns == 0)
            buyTickets.isEnabled = false
        else {
            buyTickets.setOnClickListener{
                val intent: Intent = Intent(this, SeatSelection::class.java)

                intent.putExtra("id", id)
                intent.putExtra("titulo", titule)
                intent.putExtra("seats", ns)

                this.startActivity(intent)
            }
        }
    }
}