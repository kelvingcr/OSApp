package br.com.kelvingcr.os.listeners

import br.com.kelvingcr.os.model.ClienteModel

interface APIListener {

    fun onResponse(model: ClienteModel)
    fun onFailure(str: String)
}