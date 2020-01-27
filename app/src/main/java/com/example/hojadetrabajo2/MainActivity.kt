//UNIVERSIDAD DEL VALLE DE GUATEMALA
//CURSO DE APLICACIONES MOBILES Y JUEGOS
//DIEDGO DE JESUS ARREDONDO TURCIOS
//19422
//SECCION: 20
//CONTROLADOR DEL CONTADOR DE VUELTAS

package com.example.hojadetrabajo2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private var contador = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Declaracion de variables
        var textView: TextView = findViewById(R.id.texto)
        var imageView: ImageView = findViewById(R.id.imagen)
        var avanzar: Button = findViewById(R.id.avanzar)
        var repetir: Button = findViewById(R.id.repetir)

        //Cuando se presiona el de avanzar
        avanzar.setOnClickListener(){
            this.avanzar()
            textView.text = contador.toString()
        }

        //Cuando se presiona el de repetir
        repetir.setOnClickListener(){
            this.repetir()
            textView.text = contador.toString()
        }

        //Cuando se deja presionado
        avanzar.setOnLongClickListener(){
            this.fatantes()
            true
        }

    }

    //funcion para avanzar en el contador
    fun avanzar(){
        if(contador < 20){
            contador += 1
        }
        if  (contador == 10) {
            val text = "¡¡¡¡Primera Meta!!!!"
            val duration = Toast.LENGTH_SHORT
            val toast = Toast.makeText(applicationContext, text , duration)
            toast.show()
        }
        if  (contador == 20) {
            val text = "¡¡¡¡Felicitaciones!!!!"
            val duration = Toast.LENGTH_SHORT
            val toast = Toast.makeText(applicationContext, text , duration)
            toast.show()
            imagen.setImageResource(R.drawable.image)
        }
    }
    //funcion para reiniciar en el contador

    fun repetir(){
        contador = 0
        imagen.setImageResource(R.drawable.empty)
    }

    //funcion para mostrar los toats con las vueltas faltantes para la meta
    fun fatantes(){
        var faltantes = 0
        faltantes = if (contador < 10) {
            10 - contador
        } else {
            20 - contador
        }
        val text = faltantes.toString()
        val duration = Toast.LENGTH_SHORT
        val toast = Toast.makeText(applicationContext, "Faltan " + text + " para la siguente meta", duration)
        toast.show()
    }
}
