package org.simpleapp.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import org.simpleapp.AppContainer
import org.simpleapp.domain.repository.AppCatalogRepository
import org.simpleapp.presentation.appdetails.AppDetailsScreen

object Routes {
    const val CATALOG = "catalog"
    const val APP_DETAILS = "app_details/{appId}"

    fun appDetails(appId: String) = "app_details/$appId"
}

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    repository: AppCatalogRepository = AppContainer.appCatalogRepository
) {
    NavHost(
        navController = navController,
        startDestination = Routes.CATALOG,
        modifier = modifier
    ) {
        composable(Routes.CATALOG) {
            AppCatalogScreen(
                onAppClick = { app ->
                    navController.navigate(Routes.appDetails(app.id))
                }
            )
        }

        composable(
            route = Routes.APP_DETAILS,
            arguments = listOf(
                navArgument("appId") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val appId = backStackEntry.arguments?.getString("appId") ?: return@composable
            val app = repository.getAppById(appId) ?: return@composable

            AppDetailsScreen(
                app = app,
                showcaseApps = repository.getShowcaseApps(),
                onBackClick = { navController.popBackStack() },
                onShowcaseAppClick = {
                    navController.navigate(Routes.CATALOG) {
                        popUpTo(Routes.CATALOG) { inclusive = true }
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}
