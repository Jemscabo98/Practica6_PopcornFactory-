package montoya.eduardo.practica6_popcornfactory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class Descripcion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_descripcion)

        var img: ImageView = findViewById(R.id.imgDescripcion)
        var name: TextView = findViewById(R.id.txtTituloDescripcion)
        var descrip: TextView = findViewById(R.id.txtDescripcion)

        val bundle = intent.extras

        if (bundle != null)
        {
            img.setImageResource(bundle.getInt("header"))
            name.setText(bundle.getString("titulo"))
            descrip.setText(bundle.getString("sinopsis"))
        }
    }
}