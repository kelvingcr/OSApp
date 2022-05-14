package br.com.kelvingcr.os.listeners

import br.com.kelvingcr.os.model.ClienteModel
import br.com.kelvingcr.os.model.TecnicoModel

interface TecnicosAllListener {

    fun onResponse(model: List<TecnicoModel>)
    fun onFailure(str: String)
}