package com.example.gridcardviewapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.GridView

class MainActivity : AppCompatActivity() {

    private lateinit var gvTabla:GridView

    var Nombre = arrayListOf<String>("Alvaro","Danilo","Juan","pedroxd")
    var Departamento = arrayListOf<String>("San Salvador", "Chalatenango","Santa Ana", "San vicente")
    var imagenes = arrayOf(
        R.drawable.image1,
        R.drawable.image2,
        R.drawable.image3,
        R.drawable.image4,
    )

    var imagenLista = arrayOf(
        ImgItems(imagenes.get(0),Nombre.get(0),Departamento.get(0)),
        ImgItems(imagenes.get(1),Nombre.get(1),Departamento.get(1)),
        ImgItems(imagenes.get(2),Nombre.get(2),Departamento.get(2)),
        ImgItems(imagenes.get(3),Nombre.get(3),Departamento.get(3)),
    )

    var myImagenLista = ArrayList<ImgItems>()

    var Adaptador: AdaptadorMoficado? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        for (imagen in imagenLista)
        {
            myImagenLista.add(imagen)
        }

        gvTabla = findViewById(R.id.gtTabla)

        Adaptador = AdaptadorMoficado(myImagenLista,this)
        gvTabla.adapter = Adaptador
        gvTabla.onItemClickListener = object: AdapterView.OnItemClickListener
        {

            override fun onItemClick(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {

                var ventana:Intent = Intent(applicationContext,Detalles::class.java)
                ventana.putExtra("imagen",imagenes.get(position))
                ventana.putExtra("nombre",Nombre.get(position))
                ventana.putExtra("departamento",Departamento.get(position))
                startActivity(ventana)
            }

        }
        
    }
}