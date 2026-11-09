package org.simpleapp.presentation.resources

import org.simpleapp.R
import org.simpleapp.domain.model.AppIcon

fun AppIcon.drawableResource(): Int = when (this) {
    AppIcon.VK -> R.drawable.ic_app_vk
    AppIcon.MUSIC -> R.drawable.ic_app_music
    AppIcon.TELEGRAM -> R.drawable.ic_app_telegram
    AppIcon.KINOPOISK -> R.drawable.ic_app_kinopoisk
    AppIcon.MAPS -> R.drawable.ic_app_maps
    AppIcon.MAIL -> R.drawable.ic_app_mail
    AppIcon.SBER -> R.drawable.ic_app_sber
    AppIcon.CALENDAR -> R.drawable.ic_app_calendar
}

fun AppIcon.backgroundColorResource(): Int = when (this) {
    AppIcon.VK -> R.color.app_icon_vk_background
    AppIcon.MUSIC -> R.color.app_icon_music_background
    AppIcon.TELEGRAM -> R.color.app_icon_telegram_background
    AppIcon.KINOPOISK -> R.color.app_icon_kinopoisk_background
    AppIcon.MAPS -> R.color.app_icon_maps_background
    AppIcon.MAIL -> R.color.app_icon_mail_background
    AppIcon.SBER -> R.color.app_icon_sber_background
    AppIcon.CALENDAR -> R.color.app_icon_calendar_background
}
