package com.example.examen01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView

class CrearEmpresa : AppCompatActivity() {

    val baseDatos = BaseDatos(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_editar_empresa)

        val btn_guardar = findViewById<ImageView>(R.id.img_view_guardar)

        btn_guardar.setOnClickListener{
            crearEmpresa()
        }

        val btn_cancelar = findViewById<ImageView>(R.id.img_view_cancelar)
        btn_cancelar.setOnClickListener {
            abrirActividad(EmpresaActivity1::class.java)
        }


    }



    fun crearEmpresa(){

        val ruc = findViewById<TextView>(R.id.txt_ruc)
        val razonSocial = findViewById<TextView>(R.id.txt_razon_social)
        val direccion = findViewById<TextView>(R.id.txt_direccion)
        val telefono = findViewById<TextView>(R.id.txt_telefono)

        val rucIngreso = ruc.text.toString()
        val razonSocialIngres = razonSocial.text.toString()
        val direccionIngreso = direccion.text.toString()
        val telefonoIngreso = telefono.text.toString()

        if(baseDatos!= null) {
            if( !razonSocialIngres.isEmpty() && !direccionIngreso.isEmpty() && !direccionIngreso.isEmpty() && !telefonoIngreso.isEmpty() ){

                baseDatos.crearEmpresaFormulario(rucIngreso,razonSocialIngres, direccionIngreso, telefonoIngreso.toInt())

                Log.i("base-datos", "empresa ingresado ${razonSocialIngres}")
                ruc.text = ""
                razonSocial.text = ""
                direccion.text = ""
                telefono.text = ""

                abrirActividad(EmpresaActivity1::class.java)

            } else {
                Log.i("base-datos", "llene los campos")
            }
        }

    }

    fun abrirActividad(
        clase: Class<*>,
    ){
        val intentExplicito = Intent(
            this,
            clase
        )
        startActivity(intentExplicito)
    }


}