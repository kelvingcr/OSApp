package br.com.kelvingcr.os.listeners

import br.com.kelvingcr.os.model.ClienteModel

class ValidationListener(str: String = "", model: ClienteModel = ClienteModel()) {

    private var mStatus: Boolean = true
    private var mMessage: String = ""
    private var model = model

    init {

        if (str != "") {
            mStatus = false
            mMessage = str
            this.model = ClienteModel()
        }

    }

    fun getSucess() = mStatus
    fun getFailure() = mMessage
    fun getModel() = model
}