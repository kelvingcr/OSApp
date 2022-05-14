package br.com.kelvingcr.os.ui.slideshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.kelvingcr.os.listeners.ClienteAllListener
import br.com.kelvingcr.os.listeners.OSAllListener
import br.com.kelvingcr.os.model.ClienteModel
import br.com.kelvingcr.os.model.OSModel
import br.com.kelvingcr.os.repository.ClienteRepository
import br.com.kelvingcr.os.repository.OSRepository

class OSViewModel : ViewModel() {

    private var osRepository = OSRepository()

    private val mOSList = MutableLiveData<List<OSModel>>()
    val osList: LiveData<List<OSModel>> = mOSList

    fun load() {

        osRepository.getAll(object : OSAllListener {
            override fun onResponse(model: List<OSModel>) {
                mOSList.value = model
            }

            override fun onFailure(str: String) {

            }

        })
    }
}