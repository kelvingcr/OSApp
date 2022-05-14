package br.com.kelvingcr.os.ui.gallery

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.kelvingcr.os.listeners.ClienteAllListener
import br.com.kelvingcr.os.listeners.ValidationListener
import br.com.kelvingcr.os.model.ClienteModel
import br.com.kelvingcr.os.repository.ClienteRepository

class ClienteViewModel : ViewModel() {

    private var clienteRepository = ClienteRepository()
    private val mClienteList = MutableLiveData<List<ClienteModel>>()
    val clienteList: LiveData<List<ClienteModel>> = mClienteList



    fun load() {
        clienteRepository.getAll(object : ClienteAllListener {
            override fun onResponse(model: List<ClienteModel>) {
                mClienteList.value = model
            }

            override fun onFailure(str: String) {

            }

        })
    }

    fun delete(id: Int, context: Context) {
        clienteRepository.delete(id, object : ClienteAllListener {
            override fun onResponse(model: List<ClienteModel>) {

            }

            override fun onFailure(str: String) {

                Toast.makeText(context, str, Toast.LENGTH_LONG).show()

            }

        })
    }
}