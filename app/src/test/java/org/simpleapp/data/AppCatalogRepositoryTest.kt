package org.simpleapp.data

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class AppCatalogRepositoryTest {
    @Test
    fun appsHaveUniqueIdsAndCompletePresentationResources() {
        val apps = AppCatalogRepository.apps

        assertFalse(apps.isEmpty())
        assertEquals(apps.size, apps.map { it.id }.distinct().size)
        assertTrue(
            apps.all { app ->
                app.id.isNotBlank() &&
                    app.nameRes != 0 &&
                    app.descriptionRes != 0 &&
                    app.categoryRes != 0 &&
                    app.iconRes != 0 &&
                    app.iconBackgroundRes != 0
            }
        )
    }

    @Test
    fun showcaseHasExactlyNineApps() {
        assertEquals(9, AppCatalogRepository.showcaseApps.size)
    }
}
