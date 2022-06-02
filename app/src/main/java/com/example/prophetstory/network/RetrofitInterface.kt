package com.example.prophetstory.network

import com.example.prophetstory.model.ResponseNabiItem
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitInterface {

    @GET("v1/nabi")
    fun getDataNabi() : Call<List<ResponseNabiItem>>

    @GET("v1/rasul")
    fun getDataRasul() : Call<List<ResponseNabiItem>>
}