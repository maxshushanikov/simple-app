package org.simpleapp.data.repository

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test
import org.simpleapp.data.source.AppCatalogLocalDataSource

class AppCatalogRepositoryTest {
    @Test
    fun appsHaveUniqueIdsAndCompleteData() {
        val apps = AppCatalogRepositoryImpl(AppCatalogLocalDataSource()).getApps()

        assertFalse(apps.isEmpty())
        assertEquals(apps.size, apps.map { it.id }.distinct().size)
        assertTrue(
            apps.all { app ->
                app.id.isNotBlank() &&
                    app.name.isNotBlank() &&
                    app.description.isNotBlank() &&
                    app.category.isNotBlank()
            }
        )
    }

    @Test
    fun showcaseHasExactlyNineApps() {
        val repository = AppCatalogRepositoryImpl(AppCatalogLocalDataSource())

        assertEquals(9, repository.getShowcaseApps().size)
        assertEquals(repository.getApps().take(9), repository.getShowcaseApps())
    }

    @Test
    fun appCanBeFoundById() {
        val repository = AppCatalogRepositoryImpl(AppCatalogLocalDataSource())

        assertEquals("VK", repository.getAppById("vk")?.name)
        assertNull(repository.getAppById("unknown"))
    }
}
