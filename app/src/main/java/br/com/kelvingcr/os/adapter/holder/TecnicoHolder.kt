package br.com.kelvingcr.os.adapter.holder

import android.app.AlertDialog
import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import br.com.kelvingcr.os.listeners.ClienteListeber
import br.com.kelvingcr.os.R
import br.com.kelvingcr.os.model.ClienteModel
import br.com.kelvingcr.os.model.TecnicoModel

class TecnicoHolder(itemView: View, private val listener: ClienteListeber) : RecyclerView.ViewHolder(itemView) {

    fun bind(tecnicoModel: TecnicoModel) {
        //Pega o elemento do layout e atribui valor
        val textName = itemView.findViewById<TextView>(R.id.tvName)
        textName.text = tecnicoModel.nome

        val cvTecnicos = itemView.findViewById<CardView>(R.id.cvTecnicos)

        cvTecnicos.setOnClickListener {
            listener.onClick(tecnicoModel.id)
        }

        cvTecnicos.setOnLongClickListener {
            AlertDialog.Builder(itemView.context)
                .setTitle("Remoção de Tecnico")
                .setMessage("Deseja mesmo remover esse tecnico? " + tecnicoModel.nome)
                .setPositiveButton("Sim") { dialog, which ->
                    listener.onDelete(tecnicoModel.id)
                }
                .setNeutralButton("Não", null)
                .show()
            true
        }


    }
}