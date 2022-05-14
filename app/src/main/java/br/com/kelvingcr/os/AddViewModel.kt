package br.com.kelvingcr.os

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.kelvingcr.os.listeners.ClienteAllListener
import br.com.kelvingcr.os.listeners.TecnicosAllListener
import br.com.kelvingcr.os.listeners.ValidationListener
import br.com.kelvingcr.os.model.ClienteModel
import br.com.kelvingcr.os.model.TecnicoModel
import br.com.kelvingcr.os.repository.ClienteRepository
import br.com.kelvingcr.os.repository.TecnicoRepository

class AddViewModel : ViewModel() {

    private var clienteRepository = ClienteRepository()
    private var tecnicoRepository = TecnicoRepository()

    private val mSave = MutableLiveData<Boolean>()
    var save: LiveData<Boolean> = mSave

    fun clienteCreate(model: ClienteModel, listener: ClienteAllListener) {

        clienteRepository.create(model, object : ClienteAllListener {

            override fun onResponse(model: List<ClienteModel>) {
                val model = model[0]
                mSave.value = model != null
            }

            override fun onFailure(str: String) {
                listener.onFailure(str)
                mSave.value = false
            }

        })
    }

    fun tecnicoCreate(model: TecnicoModel, listener: TecnicosAllListener) {

        tecnicoRepository.create(model, object : TecnicosAllListener {
            override fun onResponse(model: List<TecnicoModel>) {
                val model = model[0]
                mSave.value = model != null

            }

            override fun onFailure(str: String) {
                listener.onFailure(str)
                mSave.value = false
            }

        })
    }

    fun tecnicoUpdate(id: Int, model: TecnicoModel, listener: TecnicosAllListener) {

        tecnicoRepository.update(id, model, object : TecnicosAllListener {
            override fun onResponse(model: List<TecnicoModel>) {
                val model = model[0]
                mSave.value = model != null

            }

            override fun onFailure(str: String) {
                listener.onFailure(str)
                mSave.value = false
            }

        })
    }

    fun clienteUpdate(id: Int, model: ClienteModel, listener: ClienteAllListener) {

        clienteRepository.update(id, model, object : ClienteAllListener {
            override fun onResponse(model: List<ClienteModel>) {
                val model = model[0]
                mSave.value = model != null

            }

            override fun onFailure(str: String) {
                listener.onFailure(str)
                mSave.value = false
            }

        })
    }

}