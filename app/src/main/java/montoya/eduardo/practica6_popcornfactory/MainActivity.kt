package montoya.eduardo.practica6_popcornfactory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val introButton: Button = findViewById(R.id.introButton)

        introButton.setOnClickListener{
            val intent: Intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }

    }
}