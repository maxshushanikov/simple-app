package com.example.simpleapp.data.remote

import com.example.simpleapp.data.remote.dto.AppDetailsDto
import com.example.simpleapp.data.remote.dto.AppDto
import retrofit2.http.GET
import retrofit2.http.Path

interface AppApi {

    /** GET http://185.103.109.134/catalog */
    @GET("catalog")
    suspend fun getCatalog(): List<AppDto>

    /** GET http://185.103.109.134/{id} */
    @GET("{id}")
    suspend fun getAppDetails(@Path("id") id: String): AppDetailsDto
}
