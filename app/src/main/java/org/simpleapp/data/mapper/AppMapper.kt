package org.simpleapp.data.mapper

import org.simpleapp.data.model.AppDto
import org.simpleapp.domain.model.AppIcon
import org.simpleapp.domain.model.AppInfo

fun AppDto.toDomain(): AppInfo = AppInfo(
    id = id,
    name = name,
    description = description,
    category = category,
    icon = AppIcon.valueOf(iconKey)
)
