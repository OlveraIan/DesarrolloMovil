package com.example.holamundo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Actividad2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actividad2)

        val labelBienvenida = findViewById<TextView>(R.id.labelBienvenida)
        val nombreUsuario = intent.getStringExtra("usuario")
        val sharedPref = this.getSharedPreferences("MiSharedPrefer", MODE_PRIVATE)
        val apodo = sharedPref.getString("apodo","void")

        labelBienvenida.append(" " + nombreUsuario+ " ¿o deberia decir? "+apodo)
    }
}
