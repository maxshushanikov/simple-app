package org.simpleapp.data

import org.simpleapp.R
import org.simpleapp.model.AppInfo

object AppCatalogRepository {
    val apps = listOf(
        AppInfo(
            id = "vk",
            nameRes = R.string.app_vk_name,
            descriptionRes = R.string.app_vk_description,
            categoryRes = R.string.category_communication,
            iconRes = R.drawable.ic_app_vk,
            iconBackgroundRes = R.color.app_icon_vk_background
        ),
        AppInfo(
            id = "music",
            nameRes = R.string.app_music_name,
            descriptionRes = R.string.app_music_description,
            categoryRes = R.string.category_music,
            iconRes = R.drawable.ic_app_music,
            iconBackgroundRes = R.color.app_icon_music_background
        ),
        AppInfo(
            id = "telegram",
            nameRes = R.string.app_telegram_name,
            descriptionRes = R.string.app_telegram_description,
            categoryRes = R.string.category_communication,
            iconRes = R.drawable.ic_app_telegram,
            iconBackgroundRes = R.color.app_icon_telegram_background
        ),
        AppInfo(
            id = "kinopoisk",
            nameRes = R.string.app_kinopoisk_name,
            descriptionRes = R.string.app_kinopoisk_description,
            categoryRes = R.string.category_entertainment,
            iconRes = R.drawable.ic_app_kinopoisk,
            iconBackgroundRes = R.color.app_icon_kinopoisk_background
        ),
        AppInfo(
            id = "maps",
            nameRes = R.string.app_maps_name,
            descriptionRes = R.string.app_maps_description,
            categoryRes = R.string.category_travel,
            iconRes = R.drawable.ic_app_maps,
            iconBackgroundRes = R.color.app_icon_maps_background
        ),
        AppInfo(
            id = "mail",
            nameRes = R.string.app_mail_name,
            descriptionRes = R.string.app_mail_description,
            categoryRes = R.string.category_utility,
            iconRes = R.drawable.ic_app_mail,
            iconBackgroundRes = R.color.app_icon_mail_background
        ),
        AppInfo(
            id = "sber",
            nameRes = R.string.app_sber_name,
            descriptionRes = R.string.app_sber_description,
            categoryRes = R.string.category_finance,
            iconRes = R.drawable.ic_app_sber,
            iconBackgroundRes = R.color.app_icon_sber_background
        ),
        AppInfo(
            id = "calendar",
            nameRes = R.string.app_calendar_name,
            descriptionRes = R.string.app_calendar_description,
            categoryRes = R.string.category_utility,
            iconRes = R.drawable.ic_app_calendar,
            iconBackgroundRes = R.color.app_icon_calendar_background
        ),
        AppInfo(
            id = "vk_music",
            nameRes = R.string.app_vk_music_name,
            descriptionRes = R.string.app_vk_music_description,
            categoryRes = R.string.category_music,
            iconRes = R.drawable.ic_app_music,
            iconBackgroundRes = R.color.app_icon_music_background
        )
    )

    val showcaseApps: List<AppInfo> = apps.take(9)

    fun getAppById(id: String): AppInfo? = apps.find { it.id == id }
}
