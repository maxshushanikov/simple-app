package org.simpleapp.data.source

import org.simpleapp.data.model.AppDto

class AppCatalogLocalDataSource {
    fun getApps(): List<AppDto> = listOf(
        AppDto(
            id = "vk",
            name = "VK",
            description = "Общайтесь с друзьями и делитесь моментами",
            category = "Общение",
            iconKey = "VK"
        ),
        AppDto(
            id = "music",
            name = "Яндекс Музыка",
            description = "Музыка и подкасты для любого настроения",
            category = "Музыка",
            iconKey = "MUSIC"
        ),
        AppDto(
            id = "telegram",
            name = "Telegram",
            description = "Быстрые и безопасные сообщения",
            category = "Общение",
            iconKey = "TELEGRAM"
        ),
        AppDto(
            id = "kinopoisk",
            name = "Кинопоиск",
            description = "Фильмы, сериалы и новые впечатления",
            category = "Развлечения",
            iconKey = "KINOPOISK"
        ),
        AppDto(
            id = "maps",
            name = "Яндекс Карты",
            description = "Находите места и стройте маршруты",
            category = "Путешествия",
            iconKey = "MAPS"
        ),
        AppDto(
            id = "mail",
            name = "Почта",
            description = "Все ваши письма в одном месте",
            category = "Полезное",
            iconKey = "MAIL"
        ),
        AppDto(
            id = "sber",
            name = "СберБанк Онлайн",
            description = "Управляйте финансами и платежами",
            category = "Финансы",
            iconKey = "SBER"
        ),
        AppDto(
            id = "calendar",
            name = "Мой календарь",
            description = "Планы и важные даты всегда под рукой",
            category = "Полезное",
            iconKey = "CALENDAR"
        ),
        AppDto(
            id = "vk_music",
            name = "VK Музыка",
            description = "Музыка, подкасты и плейлисты VK",
            category = "Музыка",
            iconKey = "MUSIC"
        )
    )
}
