package br.com.kelvingcr.os.service

import br.com.kelvingcr.os.model.ClienteModel
import br.com.kelvingcr.os.model.OSModel
import retrofit2.Call
import retrofit2.http.*

interface OSService {

    @GET("os/{id}")
    fun get(@Path("id") id: Int) : Call<OSModel>

    @GET("os")
    fun list() : Call<List<OSModel>>

    @POST("os")
    fun create(@Body cliente: OSModel): Call<OSModel>

    @PUT("os/{id}")
    fun update(@Path("id") id: Int, @Body cliente: OSModel): Call<OSModel>


    @DELETE("os/{id}")
    fun delete(@Path("id") id: Int): Call<OSModel>
}