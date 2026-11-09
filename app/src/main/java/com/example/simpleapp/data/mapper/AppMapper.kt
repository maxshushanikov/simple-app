package com.example.simpleapp.data.mapper

import com.example.simpleapp.data.remote.dto.AppDetailsDto
import com.example.simpleapp.data.remote.dto.AppDto
import com.example.simpleapp.domain.model.AppDetails
import com.example.simpleapp.domain.model.AppInfo

/** Элементы без id отбрасываются (см. mapNotNull в репозитории). */
fun AppDto.toDomain(): AppInfo? {
    val safeId = id ?: return null
    return AppInfo(
        id = safeId,
        name = name.orEmpty(),
        description = description.orEmpty(),
        category = category.orEmpty(),
        iconUrl = iconUrl,
    )
}

fun AppDetailsDto.toDomain(): AppDetails? {
    val safeId = id ?: return null
    return AppDetails(
        id = safeId,
        name = name.orEmpty(),
        description = description.orEmpty(),
        category = category.orEmpty(),
        iconUrl = iconUrl,
        developer = developer.orEmpty(),
        ageRating = ageRating.orEmpty(),
        size = size.orEmpty(),
        screenshotUrls = screenshotUrls.orEmpty(),
    )
}
