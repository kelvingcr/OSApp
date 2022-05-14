package br.com.kelvingcr.os.listeners

import br.com.kelvingcr.os.model.ClienteModel

interface ClienteAllListener {

    fun onResponse(model: List<ClienteModel>)
  //  fun onResponsee(model: ClienteModel)
    fun onFailure(str: String)
}