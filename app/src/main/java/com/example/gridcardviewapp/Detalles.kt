package com.example.gridcardviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class Detalles : AppCompatActivity() {

    lateinit var ivImgFoto:ImageView
    lateinit var tvNombre:TextView
    lateinit var tvDepartamento:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalles)

        ivImgFoto = findViewById(R.id.imagenV)
       tvNombre = findViewById(R.id.txtNombre)
       tvDepartamento = findViewById(R.id.txtDepartamento)

        val bundle:Bundle=getIntent().getExtras()!!

        ivImgFoto.setImageResource(bundle.getInt("imagen"))
        tvNombre.setText(bundle.getString("nombre"))
        tvDepartamento.setText(bundle.getString("departamento"))
    }
}