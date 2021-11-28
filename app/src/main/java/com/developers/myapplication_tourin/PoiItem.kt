package com.developers.myapplication_tourin


import com.google.gson.annotations.SerializedName

data class PoiItem(
    @SerializedName("description")
    val description: String,
    @SerializedName("grade")
    val grade: String,
    @SerializedName("location")
    val location: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("summary")
    val summary: String,
    @SerializedName("temperature_C")
    val temperatureC: String,
    @SerializedName("urlPicture")
    val urlPicture: String
)