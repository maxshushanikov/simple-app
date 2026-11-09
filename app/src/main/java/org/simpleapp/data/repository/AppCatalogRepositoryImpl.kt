package org.simpleapp.data.repository

import org.simpleapp.data.mapper.toDomain
import org.simpleapp.data.source.AppCatalogLocalDataSource
import org.simpleapp.domain.model.AppInfo
import org.simpleapp.domain.repository.AppCatalogRepository

class AppCatalogRepositoryImpl(
    dataSource: AppCatalogLocalDataSource
) : AppCatalogRepository {
    private val cachedApps: List<AppInfo> by lazy {
        dataSource.getApps().map { it.toDomain() }
    }

    override fun getApps(): List<AppInfo> = cachedApps

    override fun getShowcaseApps(): List<AppInfo> = cachedApps.take(SHOWCASE_APP_COUNT)

    override fun getAppById(id: String): AppInfo? = cachedApps.find { it.id == id }

    private companion object {
        const val SHOWCASE_APP_COUNT = 9
    }
}
