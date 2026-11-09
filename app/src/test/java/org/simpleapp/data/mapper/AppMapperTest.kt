package org.simpleapp.data.mapper

import org.junit.Assert.assertEquals
import org.junit.Test
import org.simpleapp.data.model.AppDto
import org.simpleapp.domain.model.AppIcon
import org.simpleapp.domain.model.AppInfo

class AppMapperTest {
    @Test
    fun mapsDtoToDomainModel() {
        val dto = AppDto(
            id = "music",
            name = "Яндекс Музыка",
            description = "Музыка и подкасты",
            category = "Музыка",
            iconKey = "MUSIC"
        )

        assertEquals(
            AppInfo(
                id = "music",
                name = "Яндекс Музыка",
                description = "Музыка и подкасты",
                category = "Музыка",
                icon = AppIcon.MUSIC
            ),
            dto.toDomain()
        )
    }

    @Test(expected = IllegalArgumentException::class)
    fun rejectsUnknownIconKey() {
        AppDto(
            id = "app",
            name = "App",
            description = "Description",
            category = "Category",
            iconKey = "UNKNOWN"
        ).toDomain()
    }
}
