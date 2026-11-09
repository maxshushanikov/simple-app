package com.example.simpleapp.domain.model

data class AppDetails(
    val id: String,
    val name: String,
    val description: String,
    val category: String,
    val iconUrl: String?,
    val developer: String,
    val ageRating: String,
    val size: String,
    val screenshotUrls: List<String>,
)
