package com.example.holamundo

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val btninicio = findViewById<Button>(R.id.btnInicioSesion)
        val campoNombre = findViewById<EditText>(R.id.usuario)
        val campoContra = findViewById<EditText>(R.id.password)
        val campoApodo = findViewById<EditText>(R.id.apodo)

        val usuarios : HashMap <String,String> = HashMap()

        usuarios["Ian"] = "123"
        usuarios["Daniel"] = "ElSanto"
        usuarios["Kaho"] = "Gg"

        btninicio.setOnClickListener {
            val usuario = campoNombre.text.toString()
            val password = campoContra.text.toString()
            val apodo = campoApodo.text.toString()
            if (usuarios[usuario] == password) {
                val intent = android.content.Intent(this, Actividad2::class.java)
                val sharedPref = this.getSharedPreferences("MiSharedPrefer", MODE_PRIVATE)
                with(sharedPref.edit()){
                    putString("apodo",apodo)
                    apply()
                }
                intent.putExtra("usuario", usuario)
                startActivity(intent)

            } else {
                Toast.makeText(this, "Verifique el usuario o contraseña", Toast.LENGTH_SHORT).show()
            }
        }
    }
}