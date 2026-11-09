package com.example.simpleapp.data.repository

import com.example.simpleapp.domain.model.AppDetails
import com.example.simpleapp.domain.model.AppInfo

interface AppRepository {
    suspend fun getCatalog(): Result<List<AppInfo>>

    /** Пока нигде не используется в UI — понадобится в следующих заданиях. */
    suspend fun getAppDetails(id: String): Result<AppDetails>
}
