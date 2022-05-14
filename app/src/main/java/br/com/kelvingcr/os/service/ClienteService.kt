package br.com.kelvingcr.os.service

import br.com.kelvingcr.os.model.ClienteModel
import retrofit2.Call
import retrofit2.http.*

interface ClienteService {

    @GET("clientes/{id}")
    fun get(@Path("id") id: Int) : Call<ClienteModel>

    @GET("clientes")
    fun list() : Call<List<ClienteModel>>

    @POST("clientes")
    fun create(@Body cliente: ClienteModel): Call<ClienteModel>

    @PUT("clientes/{id}")
    fun update(@Path("id") id: Int, @Body cliente: ClienteModel): Call<ClienteModel>


    @DELETE("clientes/{id}")
    fun delete(@Path("id") id: Int): Call<ClienteModel>


}