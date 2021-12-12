package com.developers.tourin_1.data

import com.developers.tourin_1.model.Poi
import retrofit2.http.GET

interface ApiService {

    @GET("ASANCHEZTI/myapplication_tourin/poi")
    suspend fun getPoi(): Poi
}