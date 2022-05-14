package br.com.kelvingcr.os.listeners

import br.com.kelvingcr.os.model.ClienteModel
import br.com.kelvingcr.os.model.OSModel

interface OSAllListener {
    fun onResponse(model: List<OSModel>)
    fun onFailure(str: String)

}
