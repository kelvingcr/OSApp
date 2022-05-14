package br.com.kelvingcr.os.model

import com.google.gson.annotations.SerializedName

class OSModel {

    var id: Int = 0

    @SerializedName("dataabertura")
    var dataAbertura: String = ""

    @SerializedName("datafechamento")
    var dataFechamento: String = ""

    var prioridade: String = ""
    var observacoes: String = ""
    var status: String = ""

    @SerializedName("tecnico")
    var tecnicoID: Int = 0

    @SerializedName("cliente")
    var clienteID: Int = 0

}