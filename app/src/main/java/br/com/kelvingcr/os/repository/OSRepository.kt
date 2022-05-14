package br.com.kelvingcr.os.repository

import br.com.kelvingcr.os.listeners.OSAllListener
import br.com.kelvingcr.os.listeners.TecnicosAllListener
import br.com.kelvingcr.os.model.OSModel
import br.com.kelvingcr.os.model.TecnicoModel
import br.com.kelvingcr.os.service.OSService
import br.com.kelvingcr.os.service.TecnicoService
import br.com.kelvingcr.os.service.remote.RetrofitClient
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OSRepository {

    private val remote = RetrofitClient.createService(OSService::class.java)

    fun getAll(listener : OSAllListener) {

        val call: Call<List<OSModel>> = remote.list()

        call.enqueue(object : Callback<List<OSModel>> {
            override fun onResponse(call: Call<List<OSModel>>, response: Response<List<OSModel>>) {

                if (response.code() != 200) {

                    //Converte a mensagem de erro da api para uma string
                    val jsonObj = JSONObject(response.errorBody()!!.charStream().readText())
                    var message = jsonObj.getString("error")

                    listener.onFailure(message)

                } else {
                    response.body()?.let { listener.onResponse(it) }
                }
            }

            override fun onFailure(call: Call<List<OSModel>>, t: Throwable) {
                val s = t.message
            }
        })
    }
}