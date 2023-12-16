package com.csgm.myapplicationdiciembre

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("uf")
    fun getUF(): Call<UFResponse>
}