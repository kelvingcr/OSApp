package br.com.kelvingcr.os.service

import br.com.kelvingcr.os.model.ClienteModel
import br.com.kelvingcr.os.model.TecnicoModel
import retrofit2.Call
import retrofit2.http.*

interface TecnicoService {

    @GET("tecnicos/{id}")
    fun get(@Path("id") id: Int) : Call<TecnicoModel>

    @GET("tecnicos")
    fun list() : Call<List<TecnicoModel>>

    @POST("tecnicos")
    fun create(@Body cliente: TecnicoModel): Call<TecnicoModel>

    @PUT("tecnicos/{id}")
    fun update(@Path("id") id: Int, @Body cliente: TecnicoModel): Call<TecnicoModel>


    @DELETE("tecnicos/{id}")
    fun delete(@Path("id") id: Int): Call<TecnicoModel>
}