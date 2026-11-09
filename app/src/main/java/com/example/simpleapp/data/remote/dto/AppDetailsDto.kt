package com.example.simpleapp.data.remote.dto

import com.google.gson.annotations.SerializedName

/** Подробная информация о приложении: GET /{id}. */
data class AppDetailsDto(
    @SerializedName("id") val id: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("description") val description: String?,
    @SerializedName("category") val category: String?,
    @SerializedName("iconUrl") val iconUrl: String?,
    @SerializedName("developer") val developer: String?,
    @SerializedName("ageRating") val ageRating: String?,
    @SerializedName("size") val size: String?,
    @SerializedName("screenshotUrlList") val screenshotUrls: List<String>?,
)
