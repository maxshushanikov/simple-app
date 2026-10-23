package org.simpleapp.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import org.simpleapp.data.AppCatalogRepository
import org.simpleapp.ui.appdetails.AppDetailsScreen

object Routes {
    const val CATALOG = "catalog"
    const val APP_DETAILS = "app_details/{appId}"

    fun appDetails(appId: String) = "app_details/$appId"
}

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
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
            val app = AppCatalogRepository.getAppById(appId) ?: return@composable

            AppDetailsScreen(
                app = app,
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
