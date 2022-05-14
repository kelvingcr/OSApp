package br.com.kelvingcr.os.model

import java.io.Serializable

class ClienteModel(var id: Int = 0,   var nome: String = "", var cpf: String = "" , var telefone: String = "") : Serializable {

}