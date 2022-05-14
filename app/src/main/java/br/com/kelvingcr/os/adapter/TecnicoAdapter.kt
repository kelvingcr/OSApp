package br.com.kelvingcr.os.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.kelvingcr.os.listeners.ClienteListeber
import br.com.kelvingcr.os.R
import br.com.kelvingcr.os.adapter.holder.ClienteHolder
import br.com.kelvingcr.os.adapter.holder.TecnicoHolder
import br.com.kelvingcr.os.model.TecnicoModel

class TecnicoAdapter : RecyclerView.Adapter<TecnicoHolder>(){

    private var mTecnicoList: List<TecnicoModel> = arrayListOf()
    private lateinit var mListener: ClienteListeber

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TecnicoHolder {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.tecnico_adapter, parent, false)
        return TecnicoHolder(item, mListener)
    }

    override fun onBindViewHolder(holder: TecnicoHolder, position: Int) {
        holder.bind(mTecnicoList[position])
    }

    override fun getItemCount() = mTecnicoList.count()


    fun updateTecnico(list: List<TecnicoModel>) {
        mTecnicoList = list
        notifyDataSetChanged()
    }

    fun attachListener(listener: ClienteListeber) {
        mListener = listener
    }
}