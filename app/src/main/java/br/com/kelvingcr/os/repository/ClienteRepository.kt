package br.com.kelvingcr.os.repository

import br.com.kelvingcr.os.listeners.APIListener
import br.com.kelvingcr.os.listeners.ClienteAllListener
import br.com.kelvingcr.os.listeners.TecnicosAllListener
import br.com.kelvingcr.os.model.ClienteModel
import br.com.kelvingcr.os.model.TecnicoModel
import br.com.kelvingcr.os.service.ClienteService
import br.com.kelvingcr.os.service.remote.RetrofitClient
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ClienteRepository {

    private val remote = RetrofitClient.createService(ClienteService::class.java)

    fun get(id: Int, listener: APIListener) {

        //    val call: Call<ClienteModel> = remote.delete(5)
        val call: Call<ClienteModel> = remote.get(id)
        //val call: Call<ClienteModel> = remote.update(5, ClienteModel( 0 ,"Henrique", "211.517.070-90", "13988888887"))

        call.enqueue(object : Callback<ClienteModel> {
            override fun onResponse(call: Call<ClienteModel>, response: Response<ClienteModel>) {
                val s = response.body()

                if (response.code() != 200) {

                    //Converte a mensagem de erro da api para uma string
                    val jsonObj = JSONObject(response.errorBody()!!.charStream().readText())
                    var message = jsonObj.getString("error")

                    listener.onFailure(message)

                } else {
                    response.body()?.let { listener.onResponse(it) }
                }

            }

            override fun onFailure(call: Call<ClienteModel>, t: Throwable) {
                val s = t.message
            }

        })
    }


    fun getAll(listener : ClienteAllListener) {

        val call: Call<List<ClienteModel>> = remote.list()

        call.enqueue(object : Callback<List<ClienteModel>> {
            override fun onResponse(call: Call<List<ClienteModel>>, response: Response<List<ClienteModel>>) {

                if (response.code() != 200) {

                    //Converte a mensagem de erro da api para uma string
                    val jsonObj = JSONObject(response.errorBody()!!.charStream().readText())
                    var message = jsonObj.getString("error")

                    listener.onFailure(message)

                } else {
                    response.body()?.let { listener.onResponse(it) }
                }
            }

            override fun onFailure(call: Call<List<ClienteModel>>, t: Throwable) {
                val s = t.message
            }
        })
    }

    fun create(model: ClienteModel, listener : ClienteAllListener) {

        val call: Call<ClienteModel> = remote.create(model)

        call.enqueue(object : Callback<ClienteModel> {
            override fun onResponse(call: Call<ClienteModel>, response: Response<ClienteModel>) {
                if (response.code() != 200) {

                    //Converte a mensagem de erro da api para uma string
                    val jsonObj = JSONObject(response.errorBody()!!.charStream().readText())
                    var message = jsonObj.getString("error")

                    listener.onFailure(message)

                } else {
                    response.body()?.let { listener.onResponse(arrayListOf(it)) }
                }

            }

            override fun onFailure(call: Call<ClienteModel>, t: Throwable) {

            }

        })

    }

    fun update(id: Int, model: ClienteModel, listener : ClienteAllListener) {

        val call: Call<ClienteModel> = remote.update(id, model)

        call.enqueue(object : Callback<ClienteModel> {
            override fun onResponse(call: Call<ClienteModel>, response: Response<ClienteModel>) {
                if (response.code() != 200) {

                    //Converte a mensagem de erro da api para uma string
                    val jsonObj = JSONObject(response.errorBody()!!.charStream().readText())
                    var message = jsonObj.getString("error")

                    listener.onFailure(message)

                } else {
                    response.body()?.let { listener.onResponse(arrayListOf(it)) }
                }
            }

            override fun onFailure(call: Call<ClienteModel>, t: Throwable) {

            }

        })

    }

    fun delete(id: Int,  listener : ClienteAllListener) {

        val call: Call<ClienteModel> = remote.delete(id)

        call.enqueue(object : Callback<ClienteModel> {
            override fun onResponse(call: Call<ClienteModel>, response: Response<ClienteModel>) {
                if (response.code() != 204) {

                    //Converte a mensagem de erro da api para uma string
                    val jsonObj = JSONObject(response.errorBody()!!.charStream().readText())
                    var message = jsonObj.getString("error")

                    listener.onFailure(message)

                }
            }

            override fun onFailure(call: Call<ClienteModel>, t: Throwable) {

            }

        })

    }


}