package com.example.loginbanco

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var etNombre:EditText
    private lateinit var etContra:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etNombre = findViewById(R.id.et_Nombre)
        etContra = findViewById(R.id.et_Contra)
    }

    fun registrar(vista:View){
        val nombre = etNombre.text.toString()
        val contra = etContra.text.toString()

        if (nombre.length == 0){
            Toast.makeText(this, "Debe ingresar un nombre", Toast.LENGTH_LONG).show()
        }
        if(contra.length == 0){
            Toast.makeText(this,"Debe ingresar la contrasena", Toast.LENGTH_LONG).show()
        }
        if(nombre.length != 0 && contra.length != 0){
            Toast.makeText(this, "Registro en proceso", Toast.LENGTH_LONG).show()

            if(nombre == "David" && contra == "1234" ){
                Toast.makeText(this, "Bienvenido al sistema bancario $nombre", Toast.LENGTH_LONG).show()
                val vBanco:Intent = Intent(this, Banco::class.java)
                startActivity(vBanco)
            }else{
                Toast.makeText(this, "Usuario o contrasena incorrectos", Toast.LENGTH_LONG).show()
            }
        }
    }
}