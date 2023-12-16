package com.csgm.myapplicationdiciembre

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UfAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var ufDataList: List<SerieItem> = ArrayList()

    fun setData(newData: List<SerieItem>) {
        ufDataList = newData
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UfViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.uf_item, parent, false)
        return UfViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val ufData = ufDataList[position]
        (holder as UfViewHolder).bind(ufData)
    }


    override fun getItemCount(): Int {
        return ufDataList.size
    }

    inner class UfViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val txtFecha: TextView = itemView.findViewById(R.id.txtFecha)
        private val txtValor: TextView = itemView.findViewById(R.id.txtValor)

        fun bind(ufData: SerieItem) {
          //  txtFecha.text = ufData.fecha
          //  txtValor.text = ufData.valor.toString()

            txtFecha.text = "Fecha: ${formatFecha(ufData.fecha)}"
            txtValor.text = "Valor UF: $ ${ufData.valor}"
        }

        private fun formatFecha(fecha: String): String {
            return fecha.substring(8, 10) + "/" + fecha.substring(5, 7) + "/" + fecha.substring(0, 4)
        }
    }
}