package com.developers.tourin_1.data

class PoiRepository {

    suspend fun getPoi() = ApiFactory.retrofit.getPoi()
}

