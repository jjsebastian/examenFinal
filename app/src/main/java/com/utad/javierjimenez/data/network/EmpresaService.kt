package com.utad.javierjimenez.data.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface EmpresaService {
    @GET("homeWork/{school}")
    suspend fun getHomeWork(
        @Header("Authorization")userName: String,
        @Path("school")school:String
    ): Response<List<EmpresaResponseItem>>
}