package com.example.gridcardviewapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class AdaptadorMoficado
(
    var imagenLista:ArrayList<ImgItems>,
    var context:Context

): BaseAdapter()
{
    override fun getCount(): Int {
        return  imagenLista.size
    }

    override fun getItem(position: Int): Any {
        return imagenLista[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var vista = convertView
        if(vista==null)
        {vista = LayoutInflater.from(context).inflate(R.layout.fila_items,parent, false)
        }
        var imagenVista:ImageView = vista!!.findViewById(R.id.ivImagen)
        var tvNombre:TextView = vista!!.findViewById(R.id.tvNombre)
        var tvDepartamento:TextView = vista!!.findViewById(R.id.tvDepartamento)

        val imgIdentificador = imagenLista[position]

        imagenVista.setImageResource(imgIdentificador.imagenes)
        tvNombre.text = imgIdentificador.Nombre
        tvDepartamento.text = imgIdentificador.Departamento

        return vista!!
    }


}