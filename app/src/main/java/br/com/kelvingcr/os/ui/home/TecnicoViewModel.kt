package br.com.kelvingcr.os.ui.home

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.kelvingcr.os.listeners.ClienteAllListener
import br.com.kelvingcr.os.listeners.TecnicosAllListener
import br.com.kelvingcr.os.model.ClienteModel
import br.com.kelvingcr.os.model.TecnicoModel
import br.com.kelvingcr.os.repository.ClienteRepository
import br.com.kelvingcr.os.repository.TecnicoRepository

class TecnicoViewModel : ViewModel() {

    private var tecnicoRepository = TecnicoRepository()

    private val mTecnicoList = MutableLiveData<List<TecnicoModel>>()

    val tecnicoList: LiveData<List<TecnicoModel>> = mTecnicoList

    fun load() {
        tecnicoRepository.getAll(object : TecnicosAllListener {
            override fun onResponse(model: List<TecnicoModel>) {
                mTecnicoList.value = model
            }

            override fun onFailure(str: String) {

            }

        })
    }

    fun delete(id: Int, context: Context) {
        tecnicoRepository.delete(id, object : TecnicosAllListener {
            override fun onResponse(model: List<TecnicoModel>) {

            }

            override fun onFailure(str: String) {

                Toast.makeText(context, str, Toast.LENGTH_LONG).show()

            }

        })
    }
}