package br.com.kelvingcr.os.adapter.holder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.kelvingcr.os.listeners.ClienteListeber
import br.com.kelvingcr.os.R
import br.com.kelvingcr.os.model.ClienteModel
import br.com.kelvingcr.os.model.OSModel
import br.com.kelvingcr.os.model.TecnicoModel

class OSHolder(itemView: View, private val listener: ClienteListeber) : RecyclerView.ViewHolder(itemView) {

    fun bind(osModel: OSModel) {
        //Pega o elemento do layout e atribui valor
        val textID = itemView.findViewById<TextView>(R.id.textID)
        textID.text = osModel.id.toString()

        val textDescricao = itemView.findViewById<TextView>(R.id.textDescricao)
        textDescricao.text = osModel.observacoes

        val text_data = itemView.findViewById<TextView>(R.id.text_data)
        text_data.text = osModel.dataAbertura

        val text_prioridade = itemView.findViewById<TextView>(R.id.text_prioridade)
        text_prioridade.text = osModel.prioridade

        textID.setOnClickListener {
            listener.onClick(osModel.id)
        }
    }
}