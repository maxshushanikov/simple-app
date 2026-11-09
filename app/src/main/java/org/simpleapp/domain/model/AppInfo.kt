package org.simpleapp.domain.model

data class AppInfo(
    val id: String,
    val name: String,
    val description: String,
    val category: String,
    val icon: AppIcon
)
