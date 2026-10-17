package org.simpleapp.data

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class AppCatalogRepositoryTest {
    @Test
    fun appsHaveUniqueNamesAndCompletePresentationResources() {
        val apps = AppCatalogRepository.apps

        assertFalse(apps.isEmpty())
        assertEquals(apps.size, apps.map { it.nameRes }.distinct().size)
        assertTrue(
            apps.all { app ->
                app.nameRes != 0 &&
                    app.descriptionRes != 0 &&
                    app.categoryRes != 0 &&
                    app.iconRes != 0 &&
                    app.iconBackgroundRes != 0
            }
        )
    }
}
