package org.simpleapp

import org.simpleapp.data.repository.AppCatalogRepositoryImpl
import org.simpleapp.data.source.AppCatalogLocalDataSource
import org.simpleapp.domain.repository.AppCatalogRepository

object AppContainer {
    val appCatalogRepository: AppCatalogRepository by lazy {
        AppCatalogRepositoryImpl(AppCatalogLocalDataSource())
    }
}
