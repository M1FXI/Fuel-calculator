package com.example.tp3_ads_pb

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView
import androidx.core.content.ContextCompat.getSystemService
import java.text.NumberFormat

class MainActivity : AppCompatActivity(), View.OnFocusChangeListener{

    private lateinit var textNumberKm : EditText
    private lateinit var textNumberConsumoLitros : EditText
    private lateinit var textNumberValorGasolina : EditText

    private val paraMoeda = NumberFormat.getCurrencyInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        textNumberKm = this.findViewById<EditText>(R.id.textNumberKm)
        textNumberKm.setOnFocusChangeListener(this)

        textNumberConsumoLitros = this.findViewById<EditText>(R.id.textNumberConsumoLitros)
        textNumberConsumoLitros.setOnFocusChangeListener(this)

        textNumberValorGasolina = this.findViewById<EditText>(R.id.textNumberValorGasolina)
        textNumberValorGasolina.setOnFocusChangeListener(this)

        textNumberKm.setOnKeyListener(View.OnKeyListener { _, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_UP) {
                mostrarResultado()

                return@OnKeyListener true
            }
            false
        })

        textNumberConsumoLitros.setOnKeyListener(View.OnKeyListener { _, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_UP) {
                mostrarResultado()
                return@OnKeyListener true
            }
            false
        })

        textNumberValorGasolina.setOnKeyListener(View.OnKeyListener { _, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_UP) {
                mostrarResultado()
                return@OnKeyListener true
            }
            false
        })






    }

    private fun mostrarResultado(){

        if (textNumberKm.text.toString().isNotEmpty()
            && textNumberConsumoLitros.text.toString().isNotEmpty()
            && textNumberValorGasolina.text.toString().isNotEmpty()){

            val km = textNumberKm.text.toString().toDouble()
            val consumo = textNumberConsumoLitros.text.toString().toDouble()
            val valorGasolina = textNumberValorGasolina.text.toString().toDouble()


            val total = (km/consumo)*valorGasolina
            val textViewResultado = this.findViewById<TextView>(R.id.textViewResultado)
            textViewResultado.setText(paraMoeda.format(total))
        }
    }



    override fun onFocusChange(p0:View, p1: Boolean){
        this.mostrarResultado()

    }


}



