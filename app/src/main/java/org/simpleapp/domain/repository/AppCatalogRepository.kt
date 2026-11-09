package org.simpleapp.domain.repository

import org.simpleapp.domain.model.AppInfo

interface AppCatalogRepository {
    fun getApps(): List<AppInfo>

    fun getShowcaseApps(): List<AppInfo>

    fun getAppById(id: String): AppInfo?
}
