package com.example.simpleapp.data.remote.dto

import com.google.gson.annotations.SerializedName

/** Элемент каталога: GET /catalog. Все поля nullable, т.к. JSON приходит извне. */
data class AppDto(
    @SerializedName("id") val id: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("description") val description: String?,
    @SerializedName("category") val category: String?,
    @SerializedName("iconUrl") val iconUrl: String?,
)
