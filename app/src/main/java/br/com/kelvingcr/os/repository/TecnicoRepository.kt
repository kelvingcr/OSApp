package br.com.kelvingcr.os.repository

import br.com.kelvingcr.os.listeners.ClienteAllListener
import br.com.kelvingcr.os.listeners.TecnicosAllListener
import br.com.kelvingcr.os.model.ClienteModel
import br.com.kelvingcr.os.model.TecnicoModel
import br.com.kelvingcr.os.service.ClienteService
import br.com.kelvingcr.os.service.TecnicoService
import br.com.kelvingcr.os.service.remote.RetrofitClient
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TecnicoRepository {

    private val remote = RetrofitClient.createService(TecnicoService::class.java)

    fun getAll(listener : TecnicosAllListener) {

        val call: Call<List<TecnicoModel>> = remote.list()

        call.enqueue(object : Callback<List<TecnicoModel>> {
            override fun onResponse(call: Call<List<TecnicoModel>>, response: Response<List<TecnicoModel>>) {

                if (response.code() != 200) {

                    //Converte a mensagem de erro da api para uma string
                    val jsonObj = JSONObject(response.errorBody()!!.charStream().readText())
                    var message = jsonObj.getString("error")

                    listener.onFailure(message)

                } else {
                    response.body()?.let { listener.onResponse(it) }
                }
            }

            override fun onFailure(call: Call<List<TecnicoModel>>, t: Throwable) {
                val s = t.message
            }
        })
    }

    fun create(model: TecnicoModel, listener : TecnicosAllListener) {

        val call: Call<TecnicoModel> = remote.create(model)

        call.enqueue(object : Callback<TecnicoModel> {
            override fun onResponse(call: Call<TecnicoModel>, response: Response<TecnicoModel>) {
                if (response.code() != 200) {

                    //Converte a mensagem de erro da api para uma string
                    val jsonObj = JSONObject(response.errorBody()!!.charStream().readText())
                    var message = jsonObj.getString("error")

                    listener.onFailure(message)

                } else {
                    response.body()?.let { listener.onResponse(arrayListOf(it)) }
                }

            }

            override fun onFailure(call: Call<TecnicoModel>, t: Throwable) {

            }

        })

    }

    fun update(id: Int, model: TecnicoModel, listener : TecnicosAllListener) {

        val call: Call<TecnicoModel> = remote.update(id, model)

        call.enqueue(object : Callback<TecnicoModel> {
            override fun onResponse(call: Call<TecnicoModel>, response: Response<TecnicoModel>) {
                if (response.code() != 200) {

                    //Converte a mensagem de erro da api para uma string
                    val jsonObj = JSONObject(response.errorBody()!!.charStream().readText())
                    var message = jsonObj.getString("error")

                    listener.onFailure(message)

                } else {
                    response.body()?.let { listener.onResponse(arrayListOf(it)) }
                }

            }

            override fun onFailure(call: Call<TecnicoModel>, t: Throwable) {

            }

        })

    }

    fun delete(id: Int,  listener : TecnicosAllListener) {

        val call: Call<TecnicoModel> = remote.delete(id)

        call.enqueue(object : Callback<TecnicoModel> {
            override fun onResponse(call: Call<TecnicoModel>, response: Response<TecnicoModel>) {
                if (response.code() != 204) {

                    //Converte a mensagem de erro da api para uma string
                    val jsonObj = JSONObject(response.errorBody()!!.charStream().readText())
                    var message = jsonObj.getString("error")

                    listener.onFailure(message)

                }
            }

            override fun onFailure(call: Call<TecnicoModel>, t: Throwable) {

            }

        })

    }
}