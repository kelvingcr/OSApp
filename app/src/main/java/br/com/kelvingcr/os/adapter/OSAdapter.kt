package br.com.kelvingcr.os.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.kelvingcr.os.listeners.ClienteListeber
import br.com.kelvingcr.os.R
import br.com.kelvingcr.os.adapter.holder.ClienteHolder
import br.com.kelvingcr.os.adapter.holder.OSHolder
import br.com.kelvingcr.os.adapter.holder.TecnicoHolder
import br.com.kelvingcr.os.model.OSModel
import br.com.kelvingcr.os.model.TecnicoModel

class OSAdapter : RecyclerView.Adapter<OSHolder>(){

    private var mTecnicoList: List<OSModel> = arrayListOf()
    private lateinit var mListener: ClienteListeber

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OSHolder {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.list_os, parent, false)
        return OSHolder(item, mListener)
    }

    override fun onBindViewHolder(holder: OSHolder, position: Int) {
        holder.bind(mTecnicoList[position])
    }

    override fun getItemCount() = mTecnicoList.count()


    fun updateOS(list: List<OSModel>) {
        mTecnicoList = list
        notifyDataSetChanged()
    }

    fun attachListener(listener: ClienteListeber) {
        mListener = listener
    }
}