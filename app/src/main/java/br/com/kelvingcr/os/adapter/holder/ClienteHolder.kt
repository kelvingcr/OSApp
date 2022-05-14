package br.com.kelvingcr.os.adapter.holder

import android.app.AlertDialog
import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import br.com.kelvingcr.os.listeners.ClienteListeber
import br.com.kelvingcr.os.R
import br.com.kelvingcr.os.model.ClienteModel

class ClienteHolder(itemView: View, private val listener: ClienteListeber) : RecyclerView.ViewHolder(itemView) {

    fun bind(clienteModel: ClienteModel) {
        //Pega o elemento do layout e atribui valor
        val textName = itemView.findViewById<TextView>(R.id.tvName)
        textName.text = clienteModel.nome

        val cvClientes = itemView.findViewById<CardView>(R.id.cvClientes)

        cvClientes.setOnClickListener {
            listener.onClick(clienteModel.id)
        }

        cvClientes.setOnLongClickListener {
            AlertDialog.Builder(itemView.context)
                .setTitle("Remoção de Cliente")
                .setMessage("Deseja mesmo remover esse cliente? " + clienteModel.nome)
                .setPositiveButton("Sim") { dialog, which ->
                    listener.onDelete(clienteModel.id)
                }
                .setNeutralButton("Não", null)
                .show()
            true
        }


    }
}