package br.com.kelvingcr.os.listeners

import br.com.kelvingcr.os.model.ClienteModel

interface MsgListener {

    fun <T> onResponse(str: Class<T>)
    fun onFailure(str: String)
}