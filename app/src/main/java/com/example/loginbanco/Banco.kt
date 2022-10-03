package com.example.loginbanco

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.voice.VoiceInteractionSession
import android.view.View
import android.widget.*

class Banco : AppCompatActivity() {
    private lateinit var cbVerSaldo: CheckBox
    private lateinit var rbIngresar: RadioButton
    private lateinit var rbRetirar: RadioButton
    private lateinit var rbSalir: RadioButton
    private lateinit var tvVerSaldo: TextView
    private lateinit var etIngresar: EditText
    private lateinit var etRetirar: EditText

    private var saldo = 100.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_banco)


        cbVerSaldo = findViewById(R.id.cb_Saldo)
        rbIngresar = findViewById(R.id.rb_Ingresar)
        rbRetirar = findViewById(R.id.rb_Retirar)
        rbSalir = findViewById(R.id.rb_Salir)
        tvVerSaldo = findViewById(R.id.tv_VerSaldo)
        etIngresar = findViewById(R.id.etn_Ingresar)
        etRetirar = findViewById(R.id.etn_Retirar)
    }

    fun accion(v:View){
        tvVerSaldo.visibility = View.INVISIBLE
        etIngresar.visibility = View.INVISIBLE
        etRetirar.visibility = View.INVISIBLE

        if(cbVerSaldo.isChecked() == true){
            tvVerSaldo.visibility = View.VISIBLE
            tvVerSaldo.text = "Usuario tu saldo es $${saldo}"
        }
        if(rbIngresar.isChecked() == true){
            etIngresar.visibility = View.VISIBLE
        }
        if(rbRetirar.isChecked() == true){
            etRetirar.visibility = View.VISIBLE
        }
        if(rbSalir.isChecked() == true){
            tvVerSaldo.visibility = View.VISIBLE
            tvVerSaldo.text = "Salir"
            Toast.makeText(this, "Has decidido salir del programa", Toast.LENGTH_SHORT).show()
        }
    }

    fun procesar(Vista:View){
        tvVerSaldo.visibility = View.INVISIBLE
        etIngresar.visibility = View.INVISIBLE
        etRetirar.visibility = View.INVISIBLE

        if(cbVerSaldo.isChecked() == true){
            tvVerSaldo.visibility = View.VISIBLE
            tvVerSaldo.text = "Usuario tu saldo es $${saldo}"
        }
        if(rbIngresar.isChecked() == true){
            etIngresar.visibility = View.VISIBLE
            var ingresar = etIngresar.text.toString().toDouble()
            saldo = saldo + ingresar
            tvVerSaldo.text = "Usuario tu saldo es $$saldo"
            Toast.makeText(this, "Tu operacion se realizo con exito", Toast.LENGTH_SHORT).show()
        }
        if(rbRetirar.isChecked() == true){
            etRetirar.visibility = View.VISIBLE
            var retirar = etRetirar.text.toString().toDouble()
            if (saldo - retirar < 0.0){
                etRetirar.visibility = View.VISIBLE
                tvVerSaldo.text = "No posees suficiente dinero"
                Toast.makeText(this, "No tienes suficiente dinero", Toast.LENGTH_SHORT).show()
            }else{
                saldo = saldo - retirar
                tvVerSaldo.text = "Usuario tu saldo es $$saldo"
                Toast.makeText(this, "Tu operacion se realizo con exito", Toast.LENGTH_SHORT).show()
            }
        }

        if(rbSalir.isChecked() == true){
            tvVerSaldo.visibility = View.VISIBLE
            finish()
            System.exit(0)
        }
    }
}