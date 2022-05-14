package br.com.kelvingcr.os.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.kelvingcr.os.listeners.ClienteListeber
import br.com.kelvingcr.os.R
import br.com.kelvingcr.os.adapter.holder.ClienteHolder
import br.com.kelvingcr.os.model.ClienteModel

class ClienteAdapter : RecyclerView.Adapter<ClienteHolder>(){

    private var mClienteList: List<ClienteModel> = arrayListOf()
    private lateinit var mListener: ClienteListeber

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClienteHolder {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.cliente_adapter, parent, false)
        return ClienteHolder(item, mListener)
    }

    override fun onBindViewHolder(holder: ClienteHolder, position: Int) {
        holder.bind(mClienteList[position])
    }

    override fun getItemCount() = mClienteList.count()


    fun updateCliente(list: List<ClienteModel>) {
        mClienteList = list
        notifyDataSetChanged()
    }

    fun attachListener(listener: ClienteListeber) {
        mListener = listener
    }
}