package ipca.test.pisca

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var piscasView = findViewById<Piscas>(R.id.piscasView)

        var buttonLeft = findViewById<Button>(R.id.buttonLeft)
        var buttonRight = findViewById<Button>(R.id.buttonRight)
        var buttonCenter = findViewById<Button>(R.id.buttonCenter)

        buttonLeft.setOnClickListener {
            piscasView.setLeftArrow()
        }

        buttonRight.setOnClickListener {
            piscasView.setRightArrow()
        }

        buttonCenter.setOnClickListener {
            piscasView.setBothArrow()
        }
    }
}